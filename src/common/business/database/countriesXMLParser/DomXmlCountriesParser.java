package common.business.database.countriesXMLParser;


import common.solutions.parser.XmlParser;
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

/**
 * Created by Admin on 3/18/2019.
 */
public class DomXmlcountriesParser implements XmlParser<List<Country>> {

    @Override
    public List<Country> parse(String file) throws Exception {

        if (!new File(file).exists() || new File(file).isDirectory()) {
            throw new Exception("No such file");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(file));

        Node root = doc.getElementsByTagName("countries").item(0);
        NodeList countries = ((Element) root).getElementsByTagName("country");

        List<Country> parsedCities = new ArrayList<>();

        if (countries.getLength() > 0) {
            for (int i = 0; i < countries.getLength(); i++) {

                Node xmlCountry = countries.item(i);
                Country country = new Country();
                parsedCities.add(country);

                NodeList countryInnerTags = xmlCountry.getChildNodes();

                for (int j = 0; j < countryInnerTags.getLength(); j++) {
                    Node countryInner = countryInnerTags.item(j);

                    switch (countryInner.getNodeName()) {
                        case "name": {
                            country.setName(countryInner.getTextContent());
                            break;
                        }

                        case "climate": {
                            country.setCountryName(countryInner.getTextContent());
                            break;
                        }
                        
                        case "capital": {
                            country.setPopulation(Integer.parseInt(countryInner.getTextContent()));
                            break;
                        }
                    }
                }
            }
        }

        return parsedCities;
    }


}
