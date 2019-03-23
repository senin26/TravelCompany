package order.service;

import common.business.application.StorageType;
import order.repo.impl.OrderArrayRepo;
import order.repo.impl.OrderCollectionRepo;
import order.service.impl.OrderDefaultService;

public final class OrderServiceCreator {

    private OrderServiceCreator() {

    }

    public static OrderService getOrderService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new OrderDefaultService(new OrderArrayRepo());

            case MEMORY_COLLECTION:{
                return new OrderDefaultService(new OrderCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

