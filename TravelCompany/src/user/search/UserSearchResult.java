package user.search;

import java.util.List;

public class UserSearchResult {
    UserSearchCondition userSearchCondition;

    public UserSearchResult(UserSearchCondition userSearchCondition) {
        this.userSearchCondition = userSearchCondition;
    }

    public List getSearchResult() {
       return userSearchCondition.sort();
    }

}
