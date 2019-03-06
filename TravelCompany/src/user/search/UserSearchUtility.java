package user.search;

public class UserSearchUtility {

    private UserSearchUtility() {
    }

    public static UserSearchCondition getUserSearchCondition(SortUserType sortUserType) {

        return new UserSearchCondition(sortUserType);

    }

    public static UserSearchResult getUserSearchResult(UserSearchCondition userSearchCondition) {
        return new UserSearchResult(userSearchCondition);
    }
}
