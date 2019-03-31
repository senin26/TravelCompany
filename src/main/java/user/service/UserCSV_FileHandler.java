package user.service;

import common.business.service.CSV_FileHandler;
import common.business.service.NoSuchCSV_Exception;
import user.domain.User;

import java.io.*;

public class UserCSV_FileHandler extends CSV_FileHandler {

    UserService userService;
    File file;

    public UserCSV_FileHandler(String path, UserService userService) {
        super(path);
        this.userService = userService;
        try {
            file = new File(path);
        } catch (NoSuchCSV_Exception e) {
            e.printStackTrace();
        }
    }

    public void addUsersFromCSV() {
        String userInfo;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while ((userInfo = bufferedReader.readLine())!=null) {
                String[] splUserInfo = userInfo.split(" | ");
                    userService.insert(new User(splUserInfo[2], splUserInfo[4], Integer.valueOf(splUserInfo[6])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
