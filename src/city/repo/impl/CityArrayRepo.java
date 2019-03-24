package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import common.solutions.utils.ArrayUtils;
import storage.SequenceGenerator;
import java.util.Collections;
import java.util.List;

import static storage.Storage.citiesArray;

public class CityArrayRepo implements CityRepo {


    private int cityIndex = -1;

    @Override
    public void add(City city) {
        if (cityIndex == citiesArray.length - 1) {
            City[] newArrCitys = new City[citiesArray.length * 2];
            System.arraycopy(citiesArray, 0, newArrCitys, 0, citiesArray.length);
            citiesArray = newArrCitys;
        }

        cityIndex++;
        city.setId(SequenceGenerator.getVal());
        citiesArray[cityIndex] = city;
    }

    @Override
    public void update(City city) {
        //we already in memory, no need to update object
    }

    @Override
    public City findById(Long id) {
        Integer cityIndex = findCityIndexById(id);
        if (cityIndex != null) {
            return citiesArray[cityIndex];
        }

        return null;
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
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
