package city.service;

import city.domain.City;
import city.search.CitySearchCondition;
import common.solutions.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {
    List<? extends City> search(CitySearchCondition searchCondition);
}