package country.service;


import baseservice.AbstractMemoryService;
import country.Country;
import country.repo.CountryMemoryRepo;

public class CountryMemoryService extends AbstractMemoryService {

    public CountryMemoryService(CountryMemoryRepo repo) {
        this.repo = repo;
    }
}
