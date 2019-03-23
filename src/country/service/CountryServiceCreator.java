package country.service;

import common.business.application.StorageType;
import country.repo.impl.CountryArrayRepo;
import country.repo.impl.CountryCollectionRepo;
import country.service.impl.CountryDefaultService;

public final class CountryServiceCreator {

    private CountryServiceCreator() {

    }

    public static CountryService getCountryService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new CountryDefaultService(new CountryArrayRepo());

            case MEMORY_COLLECTION:{
                return new CountryDefaultService(new CountryCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

