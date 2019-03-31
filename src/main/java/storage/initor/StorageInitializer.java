package storage.initor;

import country.domain.Country;
import country.service.CountryService;
import storage.initor.datasourcereader.CountryCityReader;
import storage.initor.datasourcereader.CountryCityTxtFileParser;
import storage.initor.datasourcereader.CountryCityXmlStaxParser;
import storage.initor.datasourcereader.FileParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StorageInitializer {

    private CountryService countryService;

    public StorageInitializer(CountryService countryService) {
        this.countryService = countryService;
    }

    public enum DataSourceType {
        TXT_FILE, XML_FILE
    }

    public void initStorageWithCountriesAndCities(String filePath, DataSourceType dataSourceType) throws Exception {
        List<Country> countriesToPersist = getCountriesFromStorage(filePath, dataSourceType);

        if (!countriesToPersist.isEmpty()) {
            for (Country country : countriesToPersist) {
                countryService.insert(country);
            }
        }
    }

    public void initStorageWithCountriesAndCities(File[] filePaths) throws Exception {
        List<Country> countriesToPersist = getCountriesFromStorage(filePaths);

        if (!countriesToPersist.isEmpty()) {
            for (Country country : countriesToPersist) {
                countryService.insert(country);
            }
        }
    }

    private List<Country> getCountriesFromStorage(File[] filePaths) throws Exception {

        List<Country> countriesRes = new ArrayList<>();
        List<CountryCityReader> readers = new ArrayList<>();

        for (int i = 0; i < filePaths.length; i++) {
            readers.add(new CountryCityReader(filePaths[i]));
            readers.get(i).start();
            readers.get(i).join();
        }

        for (CountryCityReader each:
                readers) {
            countriesRes.addAll(each.getCountries());
        }

        return countriesRes;
    }

    private List<Country> getCountriesFromStorage(String filePath, DataSourceType dataSourceType) throws Exception {

        FileParser<List<Country>> dataSourceReader = null;

        switch (dataSourceType) {

            // todo don't forget to insert this!
            case TXT_FILE: {
                dataSourceReader = new CountryCityTxtFileParser();
                break;
            }

            case XML_FILE: {
                //dataSourceReader = new CountriesWithModelsXmlDomParser();
                dataSourceReader = new CountryCityXmlStaxParser();
                //dataSourceReader = new CountriesWithModelsXmlSaxParser();
                break;
            }
        }

        return dataSourceReader.parseFile(filePath);
    }

}
