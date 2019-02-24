package city.service;

import city.City;
import city.repo.CityMemoryRepo;

public class CityMemoryService {

    private CityMemoryRepo cityRepo = new CityMemoryRepo();

    public void addCity(City city) {
        cityRepo.addCity(city);
    }

    public City findCityByID(long id) {
        return cityRepo.findCityByID(id);
    }

    public void deleteCity(City city) {
        cityRepo.deleteCity(city);
    }

    public void deleteCity(Long id) {
        cityRepo.deleteCity(id);
    }

    public void printCitys() {
        cityRepo.printCountries();
    }

}
