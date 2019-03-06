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
                if (sortUserType.equals(SortUserType.BY_NAME)) {
                    return u1.getFirstName().compareTo(u2.getFirstName());
                }
                if (sortUserType.equals(SortUserType.BY_LAST_NAME)) {
                    return u1.getLastName().compareTo(u2.getLastName());
                }
                if (sortUserType.equals(SortUserType.BY_AGE)) {
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                return 0;
            }
        });
        return sortingList;
    }


}
