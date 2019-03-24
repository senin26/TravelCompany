package user.repo.impl;

import common.solutions.utils.ArrayUtils;
import storage.SequenceGenerator;
import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;
import user.search.UserSearchResult;
import user.search.UserSearchUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static storage.Storage.usersArray;

public class UserArrayRepo implements UserRepo {

    private int userIndex = -1;

    @Override
    public void insert(User user) {
        if (userIndex == usersArray.length - 1) {
            User[] newArrUsers = new User[usersArray.length * 2];
            System.arraycopy(usersArray, 0, newArrUsers, 0, usersArray.length);
            usersArray = newArrUsers;
        }
        userIndex++;
        user.setId(SequenceGenerator.getNextValue());
        usersArray[userIndex] = user;

    }

    @Override
    // todo this method realization is empty in the AutoService project...
    public List search(UserSearchCondition searchCondition) {
        UserSearchResult userSearchResult = UserSearchUtility.getUserSearchResult(searchCondition);
        return userSearchResult.getSearchResult();
    }


    @Override
    public void update(User user) {
        //we already in memory, no need to update object
    }


    @Override
    public User findById(Long id) {
        Integer userIndex = findUserIndexById(id);
        if (userIndex != null) {
            return usersArray[userIndex];
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        Integer userIndex = findUserIndexById(id);

        if (userIndex != null) {
            deleteUserByIndex(userIndex);
        }
    }

    private void deleteUserByIndex(int index) {
        ArrayUtils.removeElement(usersArray, index);
        userIndex--;
    }

    @Override
    public void printAll() {
        for (User user : usersArray) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(Arrays.asList(usersArray));
    }

    private Integer findUserIndexById(long userId) {
        for (int i = 0; i < usersArray.length; i++) {
            if (usersArray[i] != null && Long.valueOf(userId).equals(usersArray[i].getId())) {
                return i;
            }
        }
        return null;
    }


}
