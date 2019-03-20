package country.domain;

import common.business.domain.BaseDomain;

public class Country extends BaseDomain {

    private String name;
    private Climate climate;
    private String capital;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public Climate getClimate() {
        return climate;
    }

    public String getCapital() {
        return capital;
    }
}