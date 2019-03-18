package common.business.search;

import java.util.Comparator;

public abstract class BaseSearchCondition<ID> {
    protected ID id;
    protected OrderDirection orderDirection;
    protected OrderType orderType = OrderType.SIMPLE;
  //  protected SortType sortType;

    public ID getId() {
        return id;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    // todo why can we change id in the search condition?
    public void setId(ID id) {
        this.id = id;
    }

    public boolean needOrdering() {
        return orderDirection != null && orderType != null;
    }


}
