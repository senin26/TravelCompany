package country.domain;

import city.domain.City;
import common.business.domain.BaseDomain;

import java.util.List;

public class Country extends BaseDomain {

    private String name;
    private Climate climate;
    private String capital;
    private List cities;

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

    public void setCities(List cities) {
        this.cities = cities;
    }

    public List getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", climate=" + climate +
                ", capital='" + capital + '\'' +
                ", cities=" + cities.toString() +
                '}';
    }
}