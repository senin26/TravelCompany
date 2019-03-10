package country.repo.impl;

import country.domain.Country;
import country.repo.CountryRepo;
import country.domain.Country;
import country.search.CountrySearchCondition;

import java.util.Collections;
import java.util.List;

import static storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryRepo {

    @Override
    public void add (Object country) {
        countriesList.add((Country) country);
    }

    @Override
    public void update(Object country) {

    }

    @Override
    public Country findById(long id) {
        return findCountryById(id);
    }

    @Override
    public List<Country> search(Object searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
        Country found = findCountryById(id);

        if (found!=null) {
            countriesList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (Country country : countriesList) {
            System.out.println(country);
        }
    }

    private void deleteCountryByIndex(int index) {
        countriesList.remove(index);
    }

    private Country findCountryById(long id) {
        for (Country u:countriesList) {
            if (Long.valueOf(id).equals(u.getId())) {
                return u;
            }
        }
        return null;
    }


}
