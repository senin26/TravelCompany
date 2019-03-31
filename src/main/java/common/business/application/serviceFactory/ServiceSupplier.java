package common.business.application.serviceFactory;


import city.service.CityService;
import common.business.application.StorageType;
import country.service.CountryService;
import order.service.OrderService;
import user.service.UserService;

public final class ServiceSupplier {
    private static volatile ServiceSupplier INSTANCE;
    private ServiceFactory serviceFactory;

    public static ServiceSupplier getInstance() {
        return INSTANCE;
    }

    public static ServiceSupplier newInstance(StorageType storageType) {

        if (INSTANCE == null) {
            synchronized (ServiceSupplier.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceSupplier(storageType);
                }
            }
        }
        return INSTANCE;
    }

    private ServiceSupplier(StorageType storageType) {
        initServiceFactory(storageType);
    }

    private void initServiceFactory(StorageType storageType) {
        switch (storageType) {
            case MEMORY_ARRAY: {
                serviceFactory = new MemoryArrayServiceFactory();
            }
            default: {
                serviceFactory = new MemoryCollectionServiceFactory();
            }
        }
    }

    public UserService getUserService() {
        return serviceFactory.getUserService();
    }

    public OrderService getOrderService() {
        return serviceFactory.getOrderService();
    }

    public CountryService getCountryService() {
        return serviceFactory.getCountryService();
    }

    public CityService getCityService() {
        return serviceFactory.getCityService();
    }
}
