package city.repo.impl;

import city.repo.CityRepo;
import city.domain.City;
import city.search.CitySearchCondition;

import java.util.Collections;
import java.util.List;

import static storage.Storage.citiesList;

public class CityMemoryCollectionRepo implements CityRepo {
    
    @Override
    public void add (Object city) {
        citiesList.add((City) city);
    }

    @Override
    public void update(Object city) {

    }

    @Override
    public City findById(long id) {
        return findCityById(id);
    }

    @Override
    public List<City> search(Object searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
        City found = findCityById(id);

        if (found!=null) {
            citiesList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (City city : citiesList) {
            System.out.println(city);
        }
    }

    private void deleteCityByIndex(int index) {
        citiesList.remove(index);
    }

    private City findCityById(long id) {
        for (City u:citiesList) {
            if (Long.valueOf(id).equals(u.getId())) {
                return u;
            }
        }
        return null;
    }

}
