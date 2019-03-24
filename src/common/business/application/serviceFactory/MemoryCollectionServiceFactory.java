package common.business.application.serviceFactory;

import city.repo.CityRepo;
import city.repo.impl.CityCollectionRepo;
import city.service.CityService;
import city.service.impl.CityDefaultService;
import country.repo.CountryRepo;
import country.repo.impl.CountryCollectionRepo;
import country.service.CountryService;
import country.service.impl.CountryDefaultService;
import order.repo.OrderRepo;
import order.repo.impl.OrderCollectionRepo;
import order.service.OrderService;
import order.service.impl.OrderDefaultService;
import user.repo.UserRepo;
import user.repo.impl.UserCollectionRepo;
import user.service.UserService;
import user.service.impl.UserDefaultService;

public class MemoryCollectionServiceFactory implements ServiceFactory {

    private UserRepo userRepo = new UserCollectionRepo();
    private OrderRepo orderRepo = new OrderCollectionRepo();
    private CountryRepo countryRepo = new CountryCollectionRepo();
    private CityRepo cityRepo = new CityCollectionRepo();

    private OrderService orderService = new OrderDefaultService(orderRepo);
    private UserService userService = new UserDefaultService(userRepo, orderService);
    private CityService cityService = new CityDefaultService(cityRepo, orderRepo);
    private CountryService countryService = new CountryDefaultService(countryRepo, cityService, orderRepo);

    @Override
    public UserService getUserService() {
        return userService;
    }

    @Override
    public OrderService getOrderService() {
        return orderService;
    }

    @Override
    public CountryService getCountryService() {
        return countryService;
    }

    @Override
    public CityService getCityService() {
        return cityService;
    }
}
