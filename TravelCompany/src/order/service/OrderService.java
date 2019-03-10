package order.service;

import order.domain.Order;
import common.business.service.BaseService;
import order.search.OrderSearchCondition;

public interface OrderService extends BaseService<Order, OrderSearchCondition> {
}
