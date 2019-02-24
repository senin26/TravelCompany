package order;

import base.TravelCompanyRepo;

public class Order implements TravelCompanyRepo {
    private float price;
    private Long id;

    public float getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
