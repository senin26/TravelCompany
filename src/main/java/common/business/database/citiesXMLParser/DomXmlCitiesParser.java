/*
package common.business.database.citiesXMLParser;


import city.domain.City;
import common.solutions.parser.XmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Admin on 3/18/2019.
 *//*

public class DomXmlCitiesParser implements XmlParser<List<City>> {

    @Override
    public List<City> parse(String file) throws Exception {

        if (!new File(file).exists() || new File(file).isDirectory()) {
            throw new Exception("No such file");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(file));

        Node root = doc.getElementsByTagName("cities").item(0);
        NodeList cities = ((Element) root).getElementsByTagName("city");

        List<City> parsedCities = new ArrayList<>();

        if (cities.getLength() > 0) {
            for (int i = 0; i < cities.getLength(); i++) {

                Node xmlCity = cities.item(i);
                City city = new City();
                parsedCities.add(city);

                NodeList cityInnerTags = xmlCity.getChildNodes();

                for (int j = 0; j < cityInnerTags.getLength(); j++) {
                    Node cityInner = cityInnerTags.item(j);
                    city

                    switch (cityInner.getNodeName()) {
                        case "name": {
                            city.setName(cityInner.getTextContent());
                            break;
                        }

                        case "country": {
                            city.setCountryName(cityInner.getTextContent());
                            break;
                        }
                        
                        case "population": {
                            city.setPopulation(Integer.parseInt(cityInner.getTextContent()));
                            break;
                        }
                    }
                }
            }
        }

        return parsedCities;
    }


}
*/
