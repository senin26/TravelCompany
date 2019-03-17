package order.service;

import order.domain.Order;
import common.business.service.BaseService;
import order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {
    List<Order> search(OrderSearchCondition searchCondition);
}
