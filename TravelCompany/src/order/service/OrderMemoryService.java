package order.service;

import baseservice.AbstractMemoryService;
import order.Order;
import order.repo.OrderMemoryRepo;

public class OrderMemoryService extends AbstractMemoryService {

    public OrderMemoryService(OrderMemoryRepo repo) {
        this.repo = repo;
    }

}
