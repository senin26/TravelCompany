package storage.initor.datasourcereader.sax;

import common.solutions.xml.sax.XmlSaxUtils;
import country.domain.Country;
import storage.initor.datasourcereader.FileParser;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.util.List;

public class CountryCityXmlSaxParser implements FileParser<List<Country>> {

    @Override
    public List<Country> parseFile(String file) throws Exception {
        SAXParser saxParser = XmlSaxUtils.getParser();

        CountryCitySaxHandler saxHandler = new CountryCitySaxHandler();
        saxParser.parse(new File(file), saxHandler);
        return saxHandler.getCountries();
    }
}
