import city.service.CityServiceCreator;
import city.service.impl.CityDefaultService;
import common.business.application.StorageType;
import country.service.CountryServiceCreator;
import country.service.impl.CountryDefaultService;
import order.service.OrderServiceCreator;
import order.service.impl.OrderDefaultService;
import user.search.sort.SortComplexityType;
import user.search.sort.SortOrderDirection;
import user.search.sort.SortUserField;
import user.search.UserSearchCondition;
import user.search.UserSearchUtility;
import user.service.UserCSV_FileHandler;
import user.service.UserCSV_ServiceCreator;
import user.service.UserServiceCreator;
import user.service.impl.UserDefaultService;

public class Application {

    public static void main(String[] args) {

        UserDefaultService userService = (UserDefaultService) UserServiceCreator.getUserService(StorageType.MEMORY_COLLECTION);
        OrderDefaultService orderDefaultService = (OrderDefaultService) OrderServiceCreator.getOrderService(StorageType.MEMORY_COLLECTION);
        CountryDefaultService countryDefaultService = (CountryDefaultService) CountryServiceCreator.getCountryService(StorageType.MEMORY_COLLECTION);
        CityDefaultService cityDefaultService = (CityDefaultService) CityServiceCreator.getCityService(StorageType.MEMORY_COLLECTION);

        String path = "E:\\Serj\\EPAM\\TravelCompany\\src\\common\\business\\database\\usersCSV\\Users";

        UserCSV_FileHandler userCSV_fileHandler = UserCSV_ServiceCreator.getUserCSV_FileHandler(path, userService);
        userCSV_fileHandler.addUsersFromCSV();

        //todo Uncomment the next line to get the search result on single field
        //UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortComplexityType.SIMPLE, SortOrderDirection.ASC, SortUserField.BY_NAME);
        UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortComplexityType.COMPLEX, SortOrderDirection.ASC, SortUserField.BY_NAME, SortUserField.BY_AGE);
        System.out.println(userService.search(userSearchCondition));

    }

}
