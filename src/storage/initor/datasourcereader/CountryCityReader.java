package storage.initor.datasourcereader;

import country.domain.Country;

import java.io.File;
import java.util.List;

public class CountryCityReader extends Thread {
    private File fileWithXml;
    private List<Country> countries;

    public CountryCityReader(File fileWithXml) {
        this.fileWithXml = fileWithXml;
    }

    @Override
    public void run() {
        try {
            countries = new CountryCityXmlStaxParser().parseFile(fileWithXml.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

}
