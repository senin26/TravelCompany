import common.business.application.StorageType;
import user.domain.User;
import user.search.sort.SortComplexityType;
import user.search.sort.SortCondition;
import user.search.sort.SortOrderDirection;
import user.search.sort.SortUserField;
import user.search.UserSearchCondition;
import user.search.UserSearchUtility;
import user.service.UserServiceCreator;
import user.service.impl.UserDefaultService;

public class Application {

    public static void main(String[] args) {

        UserDefaultService userService = (UserDefaultService) UserServiceCreator.getUserService(StorageType.MEMORY_COLLECTION);
        userService.add(new User("Max", "Kuznetsov", 27));
        userService.add(new User("Evgenii", "Nezalezniy", 31));
        userService.add(new User("Oksana", "Smirnova", 23));
        userService.add(new User("Yana", "Mishina", 25));
        userService.add(new User("Viacheslav", "Kosogor", 24));
        userService.add(new User("Evgenii", "Gordon", 23));
        userService.add(new User("Yana", "Chernyshiova", 28));
        userService.add(new User("Evgenii", "Samsonov", 29));
        userService.add(new User("Yana", "Astafieva", 22));

        //todo Uncomment the next line to get the search result on single field
        //UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortComplexityType.SIMPLE, SortOrderDirection.ASC, SortUserField.BY_NAME);
        UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortComplexityType.COMPLEX, SortOrderDirection.ASC, SortUserField.BY_NAME, SortUserField.BY_AGE);
        System.out.println(userService.search(userSearchCondition));

    }

}
