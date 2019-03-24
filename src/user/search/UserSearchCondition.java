package user.search;

import common.business.search.BaseSearchCondition;
import user.search.sort.*;

public class UserSearchCondition extends BaseSearchCondition<Long> {

    // todo this class could be empty!!!
    private SortCondition sortCondition;

    public UserSearchCondition(SortComplexityType sortComplexityType, SortOrderDirection sortOrderDirection, SortUserField... sortUserField) {

        this.sortCondition = new SortCondition(sortComplexityType, sortOrderDirection, sortUserField);
    }

    public SortCondition getSortCondition() {
        return sortCondition;
    }

}
