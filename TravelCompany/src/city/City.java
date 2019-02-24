package city;

import base.TravelCompanyRepo;

public class City implements TravelCompanyRepo {
    //todo consider using this as an internal class in order.Order.java
    private String name;
    private int population;
    private boolean isCapital;
    private Long id;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
