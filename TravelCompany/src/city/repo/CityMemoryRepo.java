package city.repo;

import base.TravelCompanyRepo;
import baserepo.AbstractMemoryRepo;
import city.City;
import common.ArrayUtils;

import static storage.Storage.cities;

public class CityMemoryRepo extends AbstractMemoryRepo {

    private int cityIndex = -1;

    @Override
    public void add (TravelCompanyRepo city) {
        if (cityIndex == cities.length - 1){
            City[] citiesTemp = new City[cities.length + (cities.length>>1)];
            System.arraycopy(cities,0,citiesTemp,0,cities.length);
            cities = citiesTemp;
        }
        cityIndex++;
        cities[cityIndex] = (City) city;
    }

    @Override
    public void delete (TravelCompanyRepo city) {
        Integer index = findIndexByEntity((City) city);
        if (index!=null) {
            deleteByIndex(index);
        }
    }

    @Override
    public Integer findIndexByEntity(TravelCompanyRepo city) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equals(city)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public City findByID (long id) {
        Integer index = findIndexById(id);
        if (index!=null) {
            return cities[index];
        }
        return null;
    }

    @Override
    protected void deleteByIndex (int index) {
        ArrayUtils.deleteByIndex(cities,index);
        cityIndex--;
    }

    @Override
    public void print () {
        for (City u: cities) {
            System.out.println(u);
        }
    }

    @Override
    public Integer findIndexById (Long id) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}
