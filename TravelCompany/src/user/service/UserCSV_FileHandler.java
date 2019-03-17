package user.service;

import common.business.service.CSV_FileHandler;
import user.domain.User;

import java.io.*;

public class UserCSV_FileHandler extends CSV_FileHandler {

    UserService userService;
    File file;
    BufferedReader bufferedReader;

    public UserCSV_FileHandler(String path, UserService userService) {
        super(path);
        file = new File(path);
        this.userService = userService;
        try {
            this.bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addUsersFromCSV() {
        String userInfo;
        try {
            while ((userInfo = bufferedReader.readLine())!=null) {
                String[] splUserInfo = userInfo.split(" | ");
                    userService.add(new User(splUserInfo[2], splUserInfo[4], Integer.valueOf(splUserInfo[6])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
