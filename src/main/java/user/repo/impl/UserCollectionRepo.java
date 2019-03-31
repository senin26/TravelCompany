package user.repo.impl;

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
import static storage.Storage.usersList;


public class UserCollectionRepo implements UserRepo{

    @Override
    public void insert(User user) {
        user.setId(SequenceGenerator.getNextValue());
        usersList.add(user);
    }

    @Override
    public void update(User user) {
        //we already in memory, no need to update object
    }

    @Override
    public User findById(Long id) {
        return findUserById(id);
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        UserSearchResult userSearchResult = UserSearchUtility.getUserSearchResult(searchCondition);
        return userSearchResult.getSearchResult();
    }

    @Override
    public void deleteById(Long id) {
       User found = findUserById(id);

        if (found!=null) {
            usersList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (User user : usersList) {
            System.out.println(user);
        }
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }

    private User findUserById(long id) {
        for (User user:usersList) {
            if (Long.valueOf(id).equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

}
