package country.service.impl;

import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import country.service.CountryService;

import java.util.List;


public class CountryDefaultService implements CountryService {

    private final CountryRepo countryRepo;

    public CountryDefaultService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public void add(Country country) {
        if (country != null) {
            countryRepo.add(country);
        }
    }

    @Override
    public Country findById(Long id) {
        if (id != null) {
            return (Country) countryRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return countryRepo.search(searchCondition);
    }

    @Override
    public void update(Country country) {
        if (country.getId() != null) {
            countryRepo.update(country);
        }
    }

    @Override
    public void delete(Country country) {
        if (country.getId() != null) {
            this.deleteById(country.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            countryRepo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        countryRepo.printAll();
    }

}
