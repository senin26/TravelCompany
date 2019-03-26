import city.service.CityService;
import common.business.application.StorageType;
import common.business.application.serviceFactory.ServiceSupplier;
import common.solutions.paginator.Paginator;
import common.solutions.utils.FileUtils;
import country.domain.Country;
import country.service.CountryService;
import order.service.OrderService;
import storage.initor.datasourcereader.CountryCityXmlDomParser;
import storage.initor.datasourcereader.CountryCityXmlStaxParser;
import storage.initor.datasourcereader.sax.CountryCityXmlJAXBParser;
import user.search.UserSearchCondition;
import user.search.UserSearchUtility;
import user.search.sort.SortComplexityType;
import user.search.sort.SortOrderDirection;
import user.search.sort.SortUserField;
import user.service.UserCSV_FileHandler;
import user.service.UserCSV_ServiceCreator;
import user.service.UserService;
import user.service.impl.UserDefaultService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        /*File fileWithXml = null;
        System.out.println("----------DOM xml-parser----------\n");
        try {
            fileWithXml = FileUtils.createFileFromResource("init_data", ".xml", "/init_data.xml");
            List<Country> countries = new CountryCityXmlDomParser().parseFile(fileWithXml.getAbsolutePath());
            for (Country country : countries) {
                System.out.println(country + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml != null) {
                try {
                    Files.delete(Paths.get(fileWithXml.toURI()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        /*System.out.println("----------Stax xml-parser----------\n");
        fileWithXml = null;
        try {
            fileWithXml = FileUtils.createFileFromResource("init_data", ".xml", "/init_data.xml");
            List<Country> countries = new CountryCityXmlStaxParser().parseFile(fileWithXml.getAbsolutePath());
            for (Country country : countries) {
                System.out.println(country + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml != null) {
                try {
                    Files.delete(Paths.get(fileWithXml.toURI()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        ServiceSupplier.newInstance(StorageType.MEMORY_COLLECTION);

        UserService userService = ServiceSupplier.getInstance().getUserService();
        OrderService orderService = ServiceSupplier.getInstance().getOrderService();
        CountryService countryService = ServiceSupplier.getInstance().getCountryService();
        CityService cityService = ServiceSupplier.getInstance().getCityService();

        String path = "resources\\users";

        UserCSV_FileHandler userCSV_fileHandler = UserCSV_ServiceCreator.getUserCSV_FileHandler(path, userService);
        userCSV_fileHandler.addUsersFromCSV();

        //todo Uncomment the next line to get the search result on single field
        //UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortComplexityType.SIMPLE, SortOrderDirection.ASC, SortUserField.BY_NAME);
        UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortComplexityType.COMPLEX, SortOrderDirection.ASC, SortUserField.BY_NAME, SortUserField.BY_AGE);

        Paginator.show(userService.search(userSearchCondition), 2);

    }

}
