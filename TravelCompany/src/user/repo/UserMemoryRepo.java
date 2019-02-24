package user.repo;

import base.TravelCompanyRepo;
import baserepo.AbstractMemoryRepo;
import common.ArrayUtils;
import user.User;
import static storage.Storage.users;

public class UserMemoryRepo extends AbstractMemoryRepo {

    private int userIndex = -1;

    @Override
    public void add (TravelCompanyRepo user) {
        if (userIndex == users.length - 1){
            User[] usersTemp = new User[users.length + (users.length>>1)];
            System.arraycopy(users,0,usersTemp,0,users.length);
            users = usersTemp;
        }
        userIndex++;
        users[userIndex] = (User) user;
    }

    @Override
    public void delete (TravelCompanyRepo user) {
        Integer index = findIndexByEntity((User) user);
        if (index!=null) {
            deleteByIndex(index);
        }
    }

    @Override
    public Integer findIndexByEntity(TravelCompanyRepo user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public User findByID (long id) {
        Integer index = findIndexById(id);
        if (index!=null) {
            return users[index];
        }
        return null;
    }

    @Override
    protected void deleteByIndex (int index) {
        ArrayUtils.deleteByIndex(users,index);
        userIndex--;
    }

    @Override
    public void print () {
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Override
    public Integer findIndexById (Long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}
