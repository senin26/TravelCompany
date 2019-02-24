package country.repo;

import common.ArrayUtils;
import country.Country;

import static storage.Storage.countries;

public class CountryMemoryRepo {

    private int countryIndex = -1;

    public void addCountry (Country country) {
        if (countryIndex == countries.length - 1){
            Country[] countriesTemp = new Country[countries.length + (countries.length>>1)];
            System.arraycopy(countries,0,countriesTemp,0,countries.length);
            countries = countriesTemp;
        }
        countryIndex++;
        countries[countryIndex] = country;
    }

    public Country findCountryByID (long id) {
        Integer countryIndex = findCountryIndexById(id);
        if (countryIndex!=null) {
            return countries[countryIndex];
        }
        return null;
    }

    public void deleteCountry (Country country) {
        Integer countryIndex = findCountryIndexByEntity(country);
        if (countryIndex!=null) {
            deleteCountryByIndex(countryIndex);
        }
    }

    public void deleteCountry (Long id) {
        Integer countryIndex = findCountryIndexById(id);
        if (countryIndex!=null) {
            deleteCountryByIndex(countryIndex);
        }
    }

    private void deleteCountryByIndex (int index) {
        ArrayUtils.deleteByIndex(countries,index);
        countryIndex--;
    }

    public void printCountries () {
        for (Country u: countries) {
            System.out.println(u);
        }
    }

    public Integer findCountryIndexByEntity(Country country) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(country)) {
                return i;
            }
        }
        return null;
    }

    public Integer findCountryIndexById (Long id) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}
