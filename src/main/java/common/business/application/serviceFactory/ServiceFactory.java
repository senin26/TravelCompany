package common.business.application.serviceFactory;


import city.service.CityService;
import country.service.CountryService;
import order.service.OrderService;
import user.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    OrderService getOrderService();
    CountryService getCountryService();
    CityService getCityService();
}
