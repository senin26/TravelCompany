package order.repo;

import base.TravelCompanyRepo;
import baserepo.AbstractMemoryRepo;
import common.ArrayUtils;
import order.Order;

import static storage.Storage.orders;

public class OrderMemoryRepo extends AbstractMemoryRepo {

    private int orderIndex = -1;

    @Override
    public void add (TravelCompanyRepo order) {
        if (orderIndex == orders.length - 1){
            Order[] ordersTemp = new Order[orders.length + (orders.length>>1)];
            System.arraycopy(orders,0,ordersTemp,0,orders.length);
            orders = ordersTemp;
        }
        orderIndex++;
        orders[orderIndex] = (Order) order;
    }

    @Override
    public void delete (TravelCompanyRepo order) {
        Integer index = findIndexByEntity((Order) order);
        if (index!=null) {
            deleteByIndex(index);
        }
    }

    @Override
    public Integer findIndexByEntity(TravelCompanyRepo order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].equals(order)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Order findByID (long id) {
        Integer index = findIndexById(id);
        if (index!=null) {
            return orders[index];
        }
        return null;
    }

    @Override
    protected void deleteByIndex (int index) {
        ArrayUtils.deleteByIndex(orders,index);
        orderIndex--;
    }

    @Override
    public void print () {
        for (Order u: orders) {
            System.out.println(u);
        }
    }

    @Override
    public Integer findIndexById (Long id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}
