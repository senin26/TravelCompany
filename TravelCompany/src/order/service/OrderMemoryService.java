package order.service;

import order.Order;
import order.repo.OrderMemoryRepo;

public class OrderMemoryService {

    private OrderMemoryRepo orderRepo = new OrderMemoryRepo();

    public void addOrder(Order order) {
        orderRepo.addOrder(order);
    }

    public Order findOrderByID(long id) {
        return orderRepo.findOrderByID(id);
    }

    public void deleteOrder(Order order) {
        orderRepo.deleteOrder(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteOrder(id);
    }

    public void printOrders() {
        orderRepo.printOrders();
    }

}
