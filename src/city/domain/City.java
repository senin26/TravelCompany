package city.domain;

import common.business.domain.BaseDomain;
import country.domain.Country;

public class City extends BaseDomain {

    private String Name;
    private String countryName;
    private int population;
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
        Name = name;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return Name;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "Name='" + Name + '\'' +
                ", population=" + population +
                '}';
    }
}