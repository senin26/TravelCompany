package storage.initor.datasourcereader.sax;

import city.domain.City;
import country.domain.Country;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

import static common.solutions.utils.CollectionUtils.getLast;

public class CountryCitySaxHandler extends DefaultHandler {
    private static final String INIT_DATA_PATH = "init-data";
    private static final String COUNTRIES_PATH = INIT_DATA_PATH + "/countries";
    private static final String COUNTRY_PATH = COUNTRIES_PATH + "/country";
    private static final String COUNTRY_NAME_PATH = COUNTRY_PATH + "/name";
    private static final String CITIES_PATH = COUNTRY_PATH + "/cities";
    private static final String CITY_PATH = CITIES_PATH + "/city";
    private static final String CITY_NAME_PATH = CITY_PATH + "/name";
    private static final String CITY_DESCRIPTION_PATH = CITY_PATH + "/description";

    private StringBuilder content = new StringBuilder();
    private List<Country> countries = Collections.emptyList();
    private List<City> cities = Collections.emptyList();

    private Deque<String> tagStack = new ArrayDeque<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        content.setLength(0);
        tagStack.add(qName);
        switch (stackAsStringPath()) {
            case COUNTRIES_PATH: {
                countries = new ArrayList<>();
                break;
            }

            case COUNTRY_PATH: {
                countries.add(new Country());
                break;
            }

            case CITIES_PATH: {
                cities = new ArrayList<>();
                getLast(countries).setCities(cities);
                break;
            }
        }
    }

  /*  private boolean isPassenger(Attributes attributes) {
        return CityDiscriminator.PASSENGER.equals(CityDiscriminator.valueOf(attributes.getValue("type")));
    }*/

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String dataAsStr = content.toString();

        switch (stackAsStringPath()) {
            case COUNTRY_NAME_PATH: {
                getLast(countries).setName(dataAsStr);
                break;
            }

            case CITY_NAME_PATH: {
                getLast(cities).setName(dataAsStr);
                break;
            }

            case CITY_DESCRIPTION_PATH: {
                getLast(cities).setDescription(dataAsStr);
                break;
            }
        }
        tagStack.removeLast();
    }

/*    private BigCity getPassengerCity() {
        return (BigCity) getLast(cities);
    }

    private SmallCity getTruckCity() {
        return (SmallCity) getLast(cities);
    }*/

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        content.append(value.replaceAll("\\n",""));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        super.ignorableWhitespace(ch, start, length);
    }

    public List<Country> getCountries() {
        return countries;
    }


    private String stackAsStringPath() {
        StringBuilder fullPath = new StringBuilder();

        Iterator<String> iter = tagStack.iterator();
        while (iter.hasNext()) {
            String tag = iter.next();
            fullPath.append(tag);

            if (iter.hasNext()) {
                fullPath.append("/");
            }
        }

        return fullPath.toString();
    }

}
