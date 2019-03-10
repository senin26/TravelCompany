package order.repo.impl;

import common.solutions.utils.ArrayUtils;
import order.domain.Order;
import order.repo.OrderRepo;
import order.search.OrderSearchCondition;
import storage.SequenceGenerator;
import order.domain.Order;
import order.search.OrderSearchCondition;

import java.util.Collections;
import java.util.List;

import static storage.Storage.ordersArray;

public class OrderMemoryArrayRepo implements OrderRepo {

    private int orderIndex = -1;

    @Override
    public void add(Object order) {
        if (orderIndex == ordersArray.length - 1) {
            Order[] newArrOrders = new Order[ordersArray.length * 2];
            System.arraycopy(ordersArray, 0, newArrOrders, 0, ordersArray.length);
            ordersArray = newArrOrders;
        }

        orderIndex++;
        ((Order) order).setId(SequenceGenerator.getVal());
        ordersArray[orderIndex] = ((Order) order);
    }

    @Override
    public void update(Object order) {
        //we already in memory, no need to update object
    }

    @Override
    public Order findById(long id) {
        Integer orderIndex = findOrderIndexById(id);
        if (orderIndex != null) {
            return ordersArray[orderIndex];
        }

        return null;
    }

    @Override
    public List search(Object searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
        Integer orderIndex = findOrderIndexById(id);

        if (orderIndex != null) {
            deleteOrderByIndex(orderIndex);
        }
    }

    private void deleteOrderByIndex(int index) {
        ArrayUtils.removeElement(ordersArray, index);
        orderIndex--;
    }

    @Override
    public void printAll() {
        for (Order order : ordersArray) {
            if (order != null) {
                System.out.println(order);
            }
        }
    }

    private Integer findOrderIndexById(long orderId) {
        for (int i = 0; i < ordersArray.length; i++) {
            if (ordersArray[i] != null && Long.valueOf(orderId).equals(ordersArray[i].getId())) {
                return i;
            }
        }
        return null;
    }


}
