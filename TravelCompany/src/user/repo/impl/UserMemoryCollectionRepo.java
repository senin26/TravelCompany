package user.repo.impl;

import storage.SequenceGenerator;
import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;
import user.search.UserSearchResult;
import user.search.UserSearchUtility;

import java.util.Collections;
import java.util.List;

import static storage.Storage.usersList;


public class UserMemoryCollectionRepo implements UserRepo{

    @Override
    public void add (User user) {
        usersList.add(user);
        user.setId(SequenceGenerator.getVal());
    }

    @Override
    public void update(User user) {
        //we already in memory, no need to update object
    }

    @Override
    public User findById(long id) {
        return findUserById(id);
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        UserSearchResult userSearchResult = UserSearchUtility.getUserSearchResult(searchCondition);
        return userSearchResult.getSearchResult();
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
