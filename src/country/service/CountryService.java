package country.service;

import country.domain.Country;
import common.solutions.service.BaseService;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {
    List<Country> search(CountrySearchCondition searchCondition);
}
