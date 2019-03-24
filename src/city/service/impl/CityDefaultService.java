package city.service.impl;

import city.domain.City;
import city.domain.exception.CityExceptionMeta;
import city.domain.exception.unchecked.DeleteCityException;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import city.service.CityService;
import common.business.exceptions.TravelCompanyUncheckedException;
import order.repo.OrderRepo;

import java.util.List;

import static city.domain.exception.CityExceptionMeta.DELETE_CITY_CONSTRAINT_ERROR;


public class CityDefaultService implements CityService {

    private final CityRepo cityRepo;
    private final OrderRepo orderRepo;

    public CityDefaultService(CityRepo cityRepo, OrderRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void insert(City city) {
        if (city != null) {
            cityRepo.insert(city);
        }
    }

    @Override
    public City findById(Long id) {
        if (id != null) {
            return cityRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(City city) {
        if (city.getId() != null) {
            this.deleteById(city.getId());
        }
    }

    @Override
    public void deleteById(Long id) throws TravelCompanyUncheckedException {
        if (id != null) {

            boolean noOrders = orderRepo.countByCity(id) == 0;
            if (noOrders) {
                cityRepo.deleteById(id);
            } else {
                throw new DeleteCityException(DELETE_CITY_CONSTRAINT_ERROR);
            }

            cityRepo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

    @Override
    public List<? extends City> search(CitySearchCondition searchCondition) {
        return cityRepo.search(searchCondition);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null) {
            cityRepo.update(city);
        }
    }

    @Override
    public List<City> findAll() {
        return cityRepo.findAll();
    }
}
