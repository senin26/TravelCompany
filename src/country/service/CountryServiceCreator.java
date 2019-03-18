package country.service;

import common.business.application.StorageType;
import country.repo.impl.CountryMemoryArrayRepo;
import country.repo.impl.CountryMemoryCollectionRepo;
import country.service.impl.CountryDefaultService;

public final class CountryServiceCreator {

    private CountryServiceCreator() {

    }

    public static CountryService getCountryService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new CountryDefaultService(new CountryMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return new CountryDefaultService(new CountryMemoryCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

