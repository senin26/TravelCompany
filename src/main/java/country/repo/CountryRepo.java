package country.repo;

import common.solutions.repo.BaseRepo;
import country.domain.Country;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<Country, Long> {
    List<Country> search(CountrySearchCondition userSearchCondition);
}
