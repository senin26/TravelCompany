package city.service;


import city.repo.impl.CityMemoryArrayRepo;
import city.repo.impl.CityMemoryCollectionRepo;
import city.service.impl.CityDefaultService;
import common.business.application.StorageType;

public final class CityServiceCreator {

    private CityServiceCreator() {

    }

    public static CityService getCityService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new CityDefaultService(new CityMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return new CityDefaultService(new CityMemoryCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

