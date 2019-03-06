package user.search;

import common.business.search.BaseSearchCondition;
import user.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static storage.Storage.usersList;

public class UserSearchCondition extends BaseSearchCondition {

    private SortUserType sortUserType;
    private List<User> sortingList;

    public UserSearchCondition(SortUserType sortUserType) {
        this.sortUserType = sortUserType;
        this.sortingList = new ArrayList<>(usersList);
    }

    public List sort() {
        sortingList.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int res = 0;
                if (sortUserType.equals(SortUserType.BY_NAME)) {
                    if (u1.getFirstName().compareTo(u2.getFirstName()) > 0)
                        res = 1;
                    if (u1.getFirstName().compareTo(u2.getFirstName()) < 0)
                        res = -1;
                    if (u1.getFirstName().compareTo(u2.getFirstName()) == 0)
                        res = 0;
                }
                if (sortUserType.equals(SortUserType.BY_LAST_NAME)) {
                    if (u1.getLastName().compareTo(u2.getLastName()) > 0)
                        res = 1;
                    if (u1.getLastName().compareTo(u2.getLastName()) < 0)
                        res = -1;
                    if (u1.getLastName().compareTo(u2.getLastName()) == 0)
                        res = 0;
                }
                if (sortUserType.equals(SortUserType.BY_AGE)) {
                    if (u1.getAge() > u2.getAge())
                        return 1;
                    if (u1.getAge() < u2.getAge())
                        return -1;
                    if (u1.getAge() == u2.getAge())
                        return 0;
                }

                return res;
            }
        });
        return sortingList;
    }


}
