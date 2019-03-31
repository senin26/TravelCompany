package user.search;

import user.search.sort.*;

public class UserSearchUtility {

    private UserSearchUtility() {
    }

    public static UserSearchCondition getUserSearchCondition(SortComplexityType sortComplexityType, SortOrderDirection sortOrderDirection, SortUserField... sortUserField) {
        return new UserSearchCondition(sortComplexityType, sortOrderDirection, sortUserField);
    }

    public static UserSearchResult getUserSearchResult(UserSearchCondition userSearchCondition) {
        return new UserSearchResult(userSearchCondition);
    }
}
