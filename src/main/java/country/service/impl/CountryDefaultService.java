package country.service.impl;

import city.domain.City;
import city.service.CityService;
import common.business.exceptions.TravelCompanyUncheckedException;
import common.solutions.functionaldomainsolutions.Replaceable;
import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import country.service.CountryService;
import order.repo.OrderRepo;

import java.util.Collections;
import java.util.List;

public class CountryDefaultService implements CountryService {

    private final CountryRepo countryRepo;
    private final CityService cityService;
    private final OrderRepo orderRepo;

    public CountryDefaultService(CountryRepo countryRepo, CityService cityService, OrderRepo orderRepo) {
        this.countryRepo = countryRepo;
        this.cityService = cityService;
        this.orderRepo = orderRepo;
    }

    @Override
    public void insert(Country country) {
        if (country != null) {
            countryRepo.insert(country);
        }
    }

    @Override
    public Country findById(Long id) {
        if (id != null) {
            return countryRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return countryRepo.search(searchCondition);
    }

    @Override
    public void update(Country country) {
        if (country.getId() != null) {
            countryRepo.update(country);
        }
    }

    @Override
    public void delete(Country country) {
        if (country.getId() != null) {
            this.deleteById(country.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            countryRepo.deleteById(id);
        }
    }

    @Override
    public void removeAllCitiesFromCountry(Long countryId) throws TravelCompanyUncheckedException {
        Country country = findById(countryId);
        if (country != null) {
            List<City> cities = country.getCities() == null ? Collections.emptyList() : country.getCities();

            for (City city : cities) {
                cityService.deleteById(city.getId());
            }

        }
    }

    @Override
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public void printAll() {
        countryRepo.printAll();
    }

    @Override
    public void replaceAll(Replaceable replaceable, City city, Country country) {
         replaceable.replaceTo(city, country);
    }
}
