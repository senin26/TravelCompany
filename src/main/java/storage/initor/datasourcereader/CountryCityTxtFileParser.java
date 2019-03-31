package storage.initor.datasourcereader;

import city.domain.BigCity;
import city.domain.City;
import city.domain.CityDiscriminator;
import city.domain.SmallCity;
import storage.initor.exception.checked.InvalidCityDiscriminatorException;
import country.domain.Country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static storage.initor.exception.InitDataExceptionMeta.PARSE_CITY_DISCRIMINATOR_ERROR;

public class CountryCityTxtFileParser implements FileParser<List<Country>> {

    private static final String MARK_PLACEHOLDER = "Country:";

    @Override
    public List<Country> parseFile(String file) throws Exception {
        List<String> fileAsList = readFileToList(file);

        List<Country> result = new ArrayList<>();
        if (!fileAsList.isEmpty()) {
            List<List<String>> countriesWithCities = splitFileToSeparateCountriesWithCities(fileAsList);

            for (List<String> countryWithCities : countriesWithCities) {
                result.add(parseCountry(countryWithCities));
            }
        }

        return result;
    }

    private List<String> readFileToList(String file) throws IOException {
        List<String> fileAsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileAsList.add(line);
            }
        }

        return fileAsList;
    }

    private List<List<String>> splitFileToSeparateCountriesWithCities(List<String> fileAsList) {
        List<List<String>> countriesWithCities = new ArrayList<>();

        List<String> singlCountryWithCities = null;
        for (String dataFromFile : fileAsList) {
            if (!dataFromFile.isEmpty()) {

                //check if country begin
                if (dataFromFile.contains(MARK_PLACEHOLDER)) {
                    if (singlCountryWithCities != null && !singlCountryWithCities.isEmpty()) {
                        countriesWithCities.add(singlCountryWithCities);
                    }
                    singlCountryWithCities = new ArrayList<>();
                    singlCountryWithCities.add(dataFromFile);
                } else if (singlCountryWithCities != null) {
                    singlCountryWithCities.add(dataFromFile);
                }

            }
        }

        return countriesWithCities;
    }

    private Country parseCountry(List<String> countryWithCities) throws InvalidCityDiscriminatorException {
        String countryAsStr = countryWithCities.get(0).replaceAll(MARK_PLACEHOLDER, "");
        countryWithCities.remove(0);

        String[] cityCsv = countryWithCities.toArray(new String[0]);
        return getCountry(countryAsStr, cityCsv);
    }

    private Country getCountry(String countryCsv, String[] citiesCsv) throws InvalidCityDiscriminatorException {
        String[] attrs = countryCsv.split("\\|");
        int attrIndex = -1;

        Country country = new Country(attrs[++attrIndex].trim());
        country.setCities(new ArrayList<>());

        for (int i = 0; i < citiesCsv.length; i++) {
            String csvCity = citiesCsv[i];
            attrIndex = -1;
            attrs = csvCity.split("\\|");

            String discriminatorAsStr = attrs[++attrIndex].trim();
            City city = createCityByDiscriminator(discriminatorAsStr);
            city.setName(attrs[++attrIndex].trim());
            city.setDescription(attrs[++attrIndex].trim());

            if (BigCity.class.equals(city.getClass())) {
                appendPassengerAttributes((BigCity) city, attrs, attrIndex);
            } else if (SmallCity.class.equals(city.getClass())) {
                appendTruckAttributes((SmallCity) city, attrs, attrIndex);
            }

            country.getCities().add(city);
        }

        return country;
    }

    private City createCityByDiscriminator(String discriminatorAsStr) throws InvalidCityDiscriminatorException {
        if (CityDiscriminator.isDiscriminatorNotExists(discriminatorAsStr)) {
            throw new InvalidCityDiscriminatorException(
                    PARSE_CITY_DISCRIMINATOR_ERROR.getCode(),
                    PARSE_CITY_DISCRIMINATOR_ERROR.getDescriptionAsFormatStr(discriminatorAsStr)
            );
        } else {
            CityDiscriminator discriminator = CityDiscriminator.getDiscriminatorByName(discriminatorAsStr);
            if (CityDiscriminator.BIG_CITY.equals(discriminator)) {
                return new BigCity();
            }
            return new SmallCity();
        }
    }

    private void appendPassengerAttributes(BigCity city, String[] attrs, int attrIndex) {
        /*city.setNumberOfAirbags(Integer.parseInt(attrs[++attrIndex].trim()));
        city.setNumberOfSeats(Integer.parseInt(attrs[++attrIndex].trim()));
        city.setAudioSystemName(attrs[++attrIndex].trim());*/
    }

    private void appendTruckAttributes(SmallCity city, String[] attrs, int attrIndex) {
       /* city.setWeight(Integer.parseInt(attrs[++attrIndex].trim()));
        city.setEmbeddedKitchen("Y".equals(attrs[++attrIndex].trim()));
        city.setTankSize(Integer.parseInt(attrs[++attrIndex].trim()));*/
    }
}