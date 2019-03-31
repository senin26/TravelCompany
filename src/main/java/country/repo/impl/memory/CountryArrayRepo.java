package country.repo.impl.memory;

import common.solutions.utils.ArrayUtils;
import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static storage.Storage.countriesArray;
import static storage.Storage.countriesList;

public class CountryArrayRepo implements CountryRepo {

    private int countryIndex = -1;

    @Override
    public void insert(Country country) {
        if (countryIndex == countriesArray.length - 1) {
            Country[] newArrCountrys = new Country[countriesArray.length * 2];
            System.arraycopy(countriesArray, 0, newArrCountrys, 0, countriesArray.length);
            countriesArray = newArrCountrys;
        }

        countryIndex++;
        country.setId(SequenceGenerator.getNextValue());
        countriesArray[countryIndex] = country;
    }

    @Override
    public void update(Country country) {
        //we already in memory, no need to update object
    }

    @Override
    public Country findById(Long id) {
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
    public void deleteById(Long id) {
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

    @Override
    public List<Country> findAll() {
        return new ArrayList<>(Arrays.asList(countriesArray));
    }
}
