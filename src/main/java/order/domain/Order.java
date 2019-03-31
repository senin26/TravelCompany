package order.domain;

import city.domain.City;
import common.business.domain.BaseDomain;
import country.domain.Country;
import user.domain.User;

public class Order extends BaseDomain<Long> {
    private Country country;
    private City city;
    private User user;
    private String description;
    private float price;

    public Order() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}