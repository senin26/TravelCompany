import common.business.application.StorageType;
import user.domain.User;
import user.search.SortUserType;
import user.search.UserSearchCondition;
import user.search.UserSearchUtility;
import user.service.UserServiceCreator;
import user.service.impl.UserDefaultService;

public class Application {

    public static void main(String[] args) {

        UserDefaultService userService = (UserDefaultService) UserServiceCreator.getUserService(StorageType.MEMORY_COLLECTION);
        userService.add(new User("Max", "Kuznetsov", 27));
        userService.add(new User("Oksana", "Smirnova", 23));
        userService.add(new User("Viacheslav", "Kosogor", 24));
        userService.add(new User("Evgenii", "Gordon", 25));
        userService.add(new User("Yana", "Chernyshiova", 22));
        UserSearchCondition userSearchCondition = UserSearchUtility.getUserSearchCondition(SortUserType.BY_AGE);
        System.out.println(userService.search(userSearchCondition));

    }

}
