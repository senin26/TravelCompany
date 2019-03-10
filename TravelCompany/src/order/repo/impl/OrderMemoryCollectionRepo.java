package order.repo.impl;

import order.repo.OrderRepo;
import order.domain.Order;
import order.search.OrderSearchCondition;
import storage.SequenceGenerator;

import java.util.Collections;
import java.util.List;

import static storage.Storage.ordersList;

public class OrderMemoryCollectionRepo implements OrderRepo {

    @Override
    public void add (Object order) {
        ordersList.add((Order) order);
        ((Order) order).setId(SequenceGenerator.getVal());
    }

    @Override
    public void update(Object o) {
    }

    @Override
    public Order findById(long id) {
        return findOrderById(id);
    }

    @Override
    public List search(Object searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
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

    private void deleteOrderByIndex(int index) {
        ordersList.remove(index);
    }

    private Order findOrderById(long id) {
        for (Order o:ordersList) {
            if (Long.valueOf(id).equals(o.getId())) {
                return o;
            }
        }
        return null;
    }

}
