package order.service;

import order.domain.Order;
import common.business.service.BaseService;

public interface OrderService extends BaseService {

    void add(Order order);

    Order findById(Long id);

    void delete(Order order);
}
