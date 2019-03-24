package city.repo.impl;

import city.repo.CityRepo;
import city.domain.City;
import city.search.CitySearchCondition;

import java.util.Collections;
import java.util.List;

import static storage.Storage.citiesList;

public class CityCollectionRepo implements CityRepo {
    
    @Override
    public void insert(City city) {
        citiesList.add(city);
    }

    @Override
    public void update(City city) {

    }

    @Override
    public City findById(Long id) {
        return findCityById(id);
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
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

    @Override
    public List<City> findAll() {
        return citiesList;
    }
}
