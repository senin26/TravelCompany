package city.service.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import city.service.CityService;
import order.repo.OrderRepo;
import order.service.OrderService;

import java.util.List;


public class CityDefaultService implements CityService {

    private final CityRepo cityRepo;
    private final OrderRepo orderRepo;

    public CityDefaultService(CityRepo cityRepo, OrderRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void add(City city) {
        if (city != null) {
            cityRepo.add(city);
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
    public List<City> search(CitySearchCondition searchCondition) {
        return cityRepo.search(searchCondition);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null) {
            cityRepo.update(city);
        }
    }

    @Override
    public void delete(City city) {
        if (city.getId() != null) {
            this.deleteById(city.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            cityRepo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

}
