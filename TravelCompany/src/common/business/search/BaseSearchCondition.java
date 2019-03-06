package common.business.search;

import java.util.Comparator;

public abstract class BaseSearchCondition {
    protected Long id;
    protected SortType sortType;



    public Long getId() {
        return id;
    }

    // todo why can we change id in the search condition?
    public void setId(Long id) {
        this.id = id;
    }
}
