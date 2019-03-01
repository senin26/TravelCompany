package city.service;

import city.domain.City;
import common.business.service.BaseService;

public interface CityService extends BaseService {

    void add(City city);

    City findById(Long id);

    void delete(City city);
}
