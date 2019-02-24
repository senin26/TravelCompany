package order.repo;

import common.ArrayUtils;
import order.Order;

import static storage.Storage.orders;

public class OrderMemoryRepo {

    private int orderIndex = -1;

    public void addOrder (Order order) {
        if (orderIndex == orders.length - 1){
            Order[] ordersTemp = new Order[orders.length + (orders.length>>1)];
            System.arraycopy(orders,0,ordersTemp,0,orders.length);
            orders = ordersTemp;
        }
        orderIndex++;
        orders[orderIndex] = order;
    }

    public Order findOrderByID (long id) {
        Integer orderIndex = findOrderIndexById(id);
        if (orderIndex!=null) {
            return orders[orderIndex];
        }
        return null;
    }

    public void deleteOrder (Order order) {
        Integer orderIndex = findOrderIndexByEntity(order);
        if (orderIndex!=null) {
            deleteOrderByIndex(orderIndex);
        }
    }

    public void deleteOrder (Long id) {
        Integer orderIndex = findOrderIndexById(id);
        if (orderIndex!=null) {
            deleteOrderByIndex(orderIndex);
        }
    }

    private void deleteOrderByIndex (int index) {
        ArrayUtils.deleteByIndex(orders,index);
        orderIndex--;
    }

    public void printOrders () {
        for (Order u: orders) {
            System.out.println(u);
        }
    }

    public Integer findOrderIndexByEntity(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].equals(order)) {
                return i;
            }
        }
        return null;
    }

    public Integer findOrderIndexById (Long id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}
