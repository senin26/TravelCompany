package country.repo.impl;

import common.solutions.utils.ArrayUtils;
import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import country.domain.Country;
import country.search.CountrySearchCondition;
import storage.SequenceGenerator;

import java.util.Collections;
import java.util.List;

import static storage.Storage.countriesArray;

public class CountryMemoryArrayRepo implements CountryRepo {

    private int countryIndex = -1;

    @Override
    public void add(Country country) {
        if (countryIndex == countriesArray.length - 1) {
            Country[] newArrCountrys = new Country[countriesArray.length * 2];
            System.arraycopy(countriesArray, 0, newArrCountrys, 0, countriesArray.length);
            countriesArray = newArrCountrys;
        }

        countryIndex++;
        country.setId(SequenceGenerator.getVal());
        countriesArray[countryIndex] = country;
    }

    @Override
    public void update(Country country) {
        //we already in memory, no need to update object
    }

    @Override
    public Country findById(long id) {
        Integer countryIndex = findCountryIndexById(id);
        if (countryIndex != null) {
            return countriesArray[countryIndex];
        }

        return null;
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
        Integer countryIndex = findCountryIndexById(id);

        if (countryIndex != null) {
            deleteCountryByIndex(countryIndex);
        }
    }

    private void deleteCountryByIndex(int index) {
        ArrayUtils.removeElement(countriesArray, index);
        countryIndex--;
    }

    @Override
    public void printAll() {
        for (Country country : countriesArray) {
            if (country != null) {
                System.out.println(country);
            }
        }
    }

    private Integer findCountryIndexById(long countryId) {
        for (int i = 0; i < countriesArray.length; i++) {
            if (countriesArray[i] != null && Long.valueOf(countryId).equals(countriesArray[i].getId())) {
                return i;
            }
        }
        return null;
    }
    
}
