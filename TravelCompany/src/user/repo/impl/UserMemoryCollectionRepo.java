package user.repo.impl;

import base.TravelCompanyRepo;
import baserepo.AbstractMemoryRepo;

import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;

import java.util.Collections;
import java.util.List;

import static storage.Storage.usersList;

public class UserMemoryCollectionRepo implements UserRepo {

    @Override
    public void add (User user) {
        usersList.add(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(long id) {
        return findUserById(id);
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
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

    private void deleteUserByIndex(int index) {
        usersList.remove(index);
    }

    private User findUserById(long id) {
        for (User u:usersList) {
            if (Long.valueOf(id).equals(u.getId())) {
                return u;
            }
        }
        return null;
    }

}
