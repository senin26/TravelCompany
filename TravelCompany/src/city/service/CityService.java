package city.service;

import city.domain.City;
import city.search.CitySearchCondition;
import common.business.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {
    List<City> search(CitySearchCondition searchCondition);
}
