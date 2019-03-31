package user.search;

import user.domain.User;
import user.search.sort.SortComplexityType;
import user.search.sort.SortCondition;

import java.util.List;

public class UserSearchResult {
    private UserSearchCondition userSearchCondition;
    private SortCondition sortCondition;
    private UserSorting userSorting;
    private List<User> listResult;

    public UserSearchResult(UserSearchCondition userSearchCondition) {
        this.userSearchCondition = userSearchCondition;
        sortCondition = userSearchCondition.getSortCondition();
        userSorting = new UserSorting(sortCondition);
    }

    public List getSearchResult() {
        if (sortCondition.getSortComplexityType().equals(SortComplexityType.SIMPLE)){

            listResult = userSorting.sort(0);
        }
        else if (sortCondition.getSortComplexityType().equals(SortComplexityType.COMPLEX)){
            userSorting.sort(0);
            listResult = userSorting.complexSort();
        }
       return listResult;
    }

}
