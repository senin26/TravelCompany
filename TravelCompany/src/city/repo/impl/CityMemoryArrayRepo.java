package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import common.solutions.utils.ArrayUtils;
import storage.SequenceGenerator;
import java.util.Collections;
import java.util.List;

import static storage.Storage.citiesArray;

public class CityMemoryArrayRepo implements CityRepo {


    private int cityIndex = -1;

    @Override
    public void add(Object city) {
        if (cityIndex == citiesArray.length - 1) {
            City[] newArrCitys = new City[citiesArray.length * 2];
            System.arraycopy(citiesArray, 0, newArrCitys, 0, citiesArray.length);
            citiesArray = newArrCitys;
        }

        cityIndex++;
        ((City) city).setId(SequenceGenerator.getVal());
        citiesArray[cityIndex] = ((City) city);
    }

    @Override
    public void update(Object city) {
        //we already in memory, no need to update object
    }

    @Override
    public City findById(long id) {
        Integer cityIndex = findCityIndexById(id);
        if (cityIndex != null) {
            return citiesArray[cityIndex];
        }

        return null;
    }

    @Override
    public List<City> search(Object searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
        Integer cityIndex = findCityIndexById(id);

        if (cityIndex != null) {
            deleteCityByIndex(cityIndex);
        }
    }

    private void deleteCityByIndex(int index) {
        ArrayUtils.removeElement(citiesArray, index);
        cityIndex--;
    }

    @Override
    public void printAll() {
        for (City city : citiesArray) {
            if (city != null) {
                System.out.println(city);
            }
        }
    }

    private Integer findCityIndexById(long cityId) {
        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i] != null && Long.valueOf(cityId).equals(citiesArray[i].getId())) {
                return i;
            }
        }
        return null;
    }

}
