package user.service;

public class UserCSV_ServiceCreator {

    private UserCSV_ServiceCreator() {
    }

    public static UserCSV_FileHandler getUserCSV_FileHandler(String path, UserService userService) {
        return new UserCSV_FileHandler(path, userService);
    }

}
