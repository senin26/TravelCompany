package user.service;

import common.business.application.StorageType;
import user.repo.impl.UserMemoryArrayRepo;
import user.repo.impl.UserMemoryCollectionRepo;
import user.service.impl.UserDefaultService;

public final class UserServiceCreator {

    private UserServiceCreator() {

    }

    public static UserService getUserService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new UserDefaultService(new UserMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return new UserDefaultService(new UserMemoryCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

