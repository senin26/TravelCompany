package city.service;

import baseservice.AbstractMemoryService;
import city.City;
import city.repo.CityMemoryRepo;

public class CityMemoryService extends AbstractMemoryService {

    public CityMemoryService(CityMemoryRepo repo) {
        this.repo = repo;
    }
}
