package country.repo.impl;

import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;

import java.util.Collections;
import java.util.List;

import static storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryRepo {

    @Override
    public void add (Country country) {
        countriesList.add(country);
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public Country findById(Long id) {
        return findCountryById(id);
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
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
