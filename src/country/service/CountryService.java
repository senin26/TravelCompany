package country.service;

import common.business.exceptions.TravelCompanyUncheckedException;
import country.domain.Country;
import common.solutions.service.BaseService;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {
    List<Country> search(CountrySearchCondition searchCondition);

    void removeAllCitiesFromCountry(Long countryId) throws TravelCompanyUncheckedException;
}
