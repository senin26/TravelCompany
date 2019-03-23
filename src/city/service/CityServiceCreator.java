package city.service;


import city.repo.impl.CityArrayRepo;
import city.repo.impl.CityCollectionRepo;
import city.service.impl.CityDefaultService;
import common.business.application.StorageType;

public final class CityServiceCreator {

    private CityServiceCreator() {

    }

    public static CityService getCityService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new CityDefaultService(new CityArrayRepo());

            case MEMORY_COLLECTION:{
                return new CityDefaultService(new CityCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

