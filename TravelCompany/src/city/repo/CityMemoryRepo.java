package city.repo;

import city.City;
import common.ArrayUtils;

import static storage.Storage.cities;

public class CityMemoryRepo {

    private int index = -1;

    public void addCity (City city) {
        if (index == cities.length - 1){
            City[] citiesTemp = new City[cities.length + (cities.length>>1)];
            System.arraycopy(cities,0,citiesTemp,0,cities.length);
            cities = citiesTemp;
        }
        index++;
        cities[index] = city;
    }

    public City findCityByID (long id) {
        Integer index = findCityIndexById(id);
        if (index!=null) {
            return cities[index];
        }
        return null;
    }

    public void deleteCity (City city) {
        Integer index = findCityIndexByEntity(city);
        if (index!=null) {
            deleteCityByIndex(index);
        }
    }

    public void deleteCity (Long id) {
        Integer index = findCityIndexById(id);
        if (index!=null) {
            deleteCityByIndex(index);
        }
    }

    private void deleteCityByIndex (int index) {
        ArrayUtils.deleteByIndex(cities,index);
        index--;
    }

    public void printCountries () {
        for (City u: cities) {
            System.out.println(u);
        }
    }

    public Integer findCityIndexByEntity(City city) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equals(city)) {
                return i;
            }
        }
        return null;
    }

    public Integer findCityIndexById (Long id) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}