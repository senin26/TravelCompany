package country.service;

import city.domain.City;
import common.business.exceptions.TravelCompanyUncheckedException;
import common.solutions.functionaldomainsolutions.Replaceable;
import country.domain.Country;
import common.solutions.service.BaseService;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {
    List<Country> search(CountrySearchCondition searchCondition);

    void removeAllCitiesFromCountry(Long countryId) throws TravelCompanyUncheckedException;

    //void replaceAll(City city, Country country);

    void replaceAll(Replaceable replaceable, City city, Country country);
}
