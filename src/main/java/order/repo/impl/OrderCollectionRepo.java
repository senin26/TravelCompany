package order.repo.impl;

import order.repo.OrderRepo;
import order.domain.Order;
import order.search.OrderSearchCondition;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static storage.Storage.ordersList;

public class OrderCollectionRepo implements OrderRepo {

    @Override
    public void insert(Order order) {
        ordersList.add(order);
        ((Order) order).setId(SequenceGenerator.getNextValue());
    }

    @Override
    public void update(Order o) {
    }

    @Override
    public Order findById(Long id) {
        return findOrderById(id);
    }

    @Override
    public List search(OrderSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
        Order found = findOrderById(id);

        if (found!=null) {
            ordersList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (Order order : ordersList) {
            System.out.println(order);
        }
    }

    private Order findOrderById(long id) {
        for (Order o:ordersList) {
            if (Long.valueOf(id).equals(o.getId())) {
                return o;
            }
        }
        return null;
    }

    @Override
    public int countByCity(long cityId) {
        int count = 0;
        for (Order order : ordersList) {
            if (cityId == order.getCity().getId()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countByCountry(long countryId) {
        int count = 0;
        for (Order order : ordersList) {
            if (countryId == order.getCity().getId()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void deleteByUserId(long userId) {

    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findByUserId(long userId) {
        List<Order> foundOrders = new ArrayList<>();

        for (Order order : ordersList) {
            if (order.getUser().getId().equals(userId)) {
                foundOrders.add(order);
            }
        }

        return foundOrders;
    }

}
