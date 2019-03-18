package common.business.application;


import city.service.CityService;
import city.service.CityServiceCreator;
import country.service.CountryService;
import country.service.CountryServiceCreator;
import order.service.OrderService;
import order.service.OrderServiceCreator;
import user.service.UserService;
import user.service.UserServiceCreator;

public final class ApplicationServiceCreator {

    private ApplicationServiceCreator() {

    }

    public static UserService getUserService(StorageType storageType) {
        return UserServiceCreator.getUserService(storageType);
    }

    public static OrderService getOrderService(StorageType storageType) {
        return OrderServiceCreator.getOrderService(storageType);
    }

    public static CountryService getCountryService(StorageType storageType) {
        return CountryServiceCreator.getCountryService(storageType);
    }

    public static CityService getCityService(StorageType storageType) {
        return CityServiceCreator.getCityService(storageType);
    }
}
