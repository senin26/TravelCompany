package country.service;

import country.domain.Country;
import common.business.service.BaseService;

public interface CountryService extends BaseService {

    void add(Country country);

    Country findById(Long id);

    void delete(Country country);
}
