package storage.initor.datasourcereader;

import city.domain.City;
import country.domain.Climate;
import country.domain.Country;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CountryCityXmlDomParser implements FileParser {

    @Override
    public List<Country> parseFile(String file) throws Exception {
        if (!new File(file).exists() || new File(file).isDirectory()) {
            throw new Exception("No such file");
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(file));
        Node root = doc.getElementsByTagName("countries").item(0);
        NodeList countries = ((Element) root).getElementsByTagName("country");
        List<Country> parsedCountries = new ArrayList<>();

        if (countries.getLength() > 0) {
            for (int i = 0; i < countries.getLength(); i++) {
                Node xmlCountry = countries.item(i);
                Country country = new Country();
                parsedCountries.add(country);
                NodeList countryInnerTags = xmlCountry.getChildNodes();

                for (int j = 0; j < countryInnerTags.getLength(); j++) {
                    Node countryInner = countryInnerTags.item(j);
                    switch (countryInner.getNodeName()) {
                        case "name": {
                            country.setName(countryInner.getTextContent());
                            break;
                        }
                        case "climate": {
                            switch (countryInner.getTextContent()) {
                                case "warm": {
                                    country.setClimate(Climate.WARM);
                                    break;
                                }
                                case "medium": {
                                    country.setClimate(Climate.MEDIUM);
                                    break;
                                }
                                case "cold": {
                                    country.setClimate(Climate.COLD);
                                    break;
                                }
                            }
                            break;
                        }
                        case "capital": {
                            country.setCapital(countryInner.getTextContent());
                            break;
                        }
                        case "cities": {
                            country.setCities(new ArrayList<City>());
                            NodeList xmlChildren = ((Element) countryInner).getElementsByTagName("city");
                            for (int k = 0; k < xmlChildren.getLength(); k++) {
                                Element xmlChild = (Element) xmlChildren.item(k);
                                City city = new City();
                                country.getCities().add(city);
                                city.setName(xmlChild.getElementsByTagName("name").item(0).getTextContent());
                                city.setPopulation(Integer.parseInt(xmlChild.getElementsByTagName("population").item(0).getTextContent()));
                            }
                            break;
                        }
                    }
                }
            }
        }
        return parsedCountries;
    }
}
