package user.service;

import common.business.application.StorageType;
import user.repo.impl.UserArrayRepo;
import user.repo.impl.UserCollectionRepo;
import user.service.impl.UserDefaultService;

public final class UserServiceCreator {

    private UserServiceCreator() {

    }

    public static UserService getUserService(StorageType storageType) {
        switch (storageType) {
            case MEMORY_ARRAY:
                return new UserDefaultService(new UserArrayRepo());

            case MEMORY_COLLECTION:
                return new UserDefaultService(new UserCollectionRepo());

            default: {
                return null;
            }
        }
    }
}

