package city.repo;

import common.business.repo.BaseRepo;
import city.domain.City;
import city.search.CitySearchCondition;
import city.domain.City;
import city.search.CitySearchCondition;

import java.util.List;

public interface CityRepo extends BaseRepo {
    void add(City city);

    City findById(long id);

    List<City> search(CitySearchCondition searchCondition);

    void update(City city);
    
    
}
