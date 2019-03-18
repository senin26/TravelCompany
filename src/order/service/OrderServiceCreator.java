package order.service;

import common.business.application.StorageType;
import order.repo.impl.OrderMemoryArrayRepo;
import order.repo.impl.OrderMemoryCollectionRepo;
import order.service.impl.OrderDefaultService;

public final class OrderServiceCreator {

    private OrderServiceCreator() {

    }

    public static OrderService getOrderService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new OrderDefaultService(new OrderMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return new OrderDefaultService(new OrderMemoryCollectionRepo());
            }

            default: {
                return null;
            }
        }
    }
}

