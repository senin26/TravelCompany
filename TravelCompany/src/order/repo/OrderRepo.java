package order.repo;

import order.domain.Order;
import common.business.repo.BaseRepo;
import order.search.OrderSearchCondition;
import order.domain.Order;
import order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo {
    void add(Order order);

    Order findById(long id);

    List<Order> search(OrderSearchCondition searchCondition);

    void update(Order order);
}
