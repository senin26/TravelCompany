package country.repo;

import country.domain.Country;
import common.business.repo.BaseRepo;
import country.domain.Country;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo {
    void add(Country country);

    Country findById(long id);

    List<Country> search(CountrySearchCondition searchCondition);

    void update(Country country);
}
