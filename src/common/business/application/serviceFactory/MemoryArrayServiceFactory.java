package common.business.application.serviceFactory;


import city.repo.CityRepo;
import city.repo.impl.CityArrayRepo;
import city.service.CityService;
import city.service.impl.CityDefaultService;
import country.repo.CountryRepo;
import country.repo.impl.CountryArrayRepo;
import country.service.CountryService;
import country.service.impl.CountryDefaultService;
import order.repo.OrderRepo;
import order.repo.impl.OrderArrayRepo;
import order.service.OrderService;
import order.service.impl.OrderDefaultService;
import user.repo.UserRepo;
import user.repo.impl.UserArrayRepo;
import user.service.UserService;
import user.service.impl.UserDefaultService;

public class MemoryArrayServiceFactory implements ServiceFactory {

    private UserRepo userRepo = new UserArrayRepo();
    private OrderRepo orderRepo = new OrderArrayRepo();
    private CountryRepo countryRepo = new CountryArrayRepo();
    private CityRepo cityRepo = new CityArrayRepo();

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
