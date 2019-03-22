package storage.initor.datasourcereader;

import city.domain.City;
import country.domain.Climate;
import country.domain.Country;
import common.solutions.xml.stax.parse.CustomStaxReader;


import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static common.solutions.xml.stax.XmlStaxUtils.readContent;


public class CountryCityXmlStaxParser implements FileParser {


    private final RuntimeException NO_END_TAG_FOUND_EXCEPTION = new RuntimeException("Suitable end tag NOT found");

    @Override
    public List<Country> parseFile(String file) throws Exception {

        List<Country> result = new ArrayList<>();

        try (CustomStaxReader staxReader = CustomStaxReader.newInstance(file)) {

            XMLStreamReader reader = staxReader.getReader();

            while (reader.hasNext()) {
                int eventType = reader.next();

                switch (eventType) {
                    case XMLStreamReader.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("countries".equals(tagName)) {
                            result = new ArrayList<>(readDocument(reader));
                        }
                        break;
                    }

                    case XMLStreamConstants.END_ELEMENT: {
                        return result;
                    }
                }
            }
        }

        throw NO_END_TAG_FOUND_EXCEPTION;
    }

    private List<Country> readDocument(XMLStreamReader reader) throws XMLStreamException {

        List<Country> marks = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("country".equals(tagName)) {
                        marks.add(readCountry(reader));
                    }
                    break;
                }

                case XMLStreamConstants.END_ELEMENT: {
                    return marks;
                }
            }
        }

        throw NO_END_TAG_FOUND_EXCEPTION;
    }

    private Country readCountry(XMLStreamReader reader) throws XMLStreamException {
        Country country = new Country();
        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("name".equals(tagName)) {
                        country.setName(readContent(reader));
                    } else if ("climate".equals(tagName)) {
                        switch (readContent(reader)) {
                            case ("warm"): {
                                country.setClimate(Climate.WARM);
                                break;
                            }
                            case ("medium"): {
                                country.setClimate(Climate.MEDIUM);
                                break;
                            }
                            case ("cold"): {
                                country.setClimate(Climate.COLD);
                                break;
                            }
                        }
                    } else if ("capital".equals(tagName)) {
                        country.setCapital(readContent(reader));
                    } else if ("cities".equals(tagName)) {
                     country.setCities(readCities(reader));
                    }
                    break;
                }

                case XMLStreamConstants.END_ELEMENT: {
                    return country;
                }
            }
        }

        throw NO_END_TAG_FOUND_EXCEPTION;
    }

    private List<City> readCities(XMLStreamReader reader) throws XMLStreamException {
        List<City> cities = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("city".equals(tagName)) {
                        cities.add(readCity(reader));
                    }
                    break;
                }

                case XMLStreamConstants.END_ELEMENT: {
                    return cities;
                }
            }
        }
        throw NO_END_TAG_FOUND_EXCEPTION;
    }

    private City readCity(XMLStreamReader reader) throws XMLStreamException {
        String type = reader.getAttributeValue(null, "type");
        City city = new City();
        //todo City city = createCity(type);

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {

                case XMLStreamReader.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    appendCommonCityData(city, tagName, reader);
                    break;
                }

                case XMLStreamConstants.END_ELEMENT: {
                    return city;
                }
            }
        }
        throw NO_END_TAG_FOUND_EXCEPTION;
    }

    /*private City createCity(String type) {
        CityDiscriminator cityDiscriminator = CityDiscriminator.valueOf(type);

        if (BIG_CITY.equals(cityDiscriminator)) {
            return new BigCity();
        } else {
            return new SmallCity();
        }
    }*/

    private void appendCommonCityData(City city, String tagName, XMLStreamReader reader) throws XMLStreamException {
        if ("name".equals(tagName)) {
            city.setName(readContent(reader));
        } else if ("population".equals(tagName)) {
            city.setPopulation(Integer.parseInt(readContent(reader)));
        }
    }

    /*private void appendPassengerAttributes(PassengerModel model, String tagName, XMLStreamReader reader) throws XMLStreamException {
        if ("numberOfAirbags".equals(tagName)) {
            model.setNumberOfAirbags(Integer.parseInt(readContent(reader)));
        } else if ("numberOfSeats".equals(tagName)) {
            model.setNumberOfSeats(Integer.parseInt(readContent(reader)));
        } else if ("audioSystemName".equals(tagName)) {
            model.setAudioSystemName(readContent(reader));
        }
    }

    private void appendTruckAttributes(TruckModel model, String tagName, XMLStreamReader reader) throws XMLStreamException {
        if ("weight".equals(tagName)) {
            model.setWeight(Integer.parseInt(readContent(reader)));
        } else if ("embeddedKitchen".equals(tagName)) {
            model.setEmbeddedKitchen("Y".equals(readContent(reader)));
        } else if ("tankSize".equals(tagName)) {
            model.setTankSize(Integer.parseInt(readContent(reader)));
        }
    }*/

}