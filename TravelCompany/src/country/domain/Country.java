package country.domain;

import base.TravelCompanyRepo;
import common.business.domain.BaseDomain;

public class Country extends BaseDomain {
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