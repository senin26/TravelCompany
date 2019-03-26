package country.domain;

import city.domain.City;
import common.business.domain.BaseDomain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Country extends BaseDomain<Long> {

    @XmlElement(name="name")
    private String name;
    @XmlElement(name="climate")
    private Climate climate;
    @XmlElement(name="capital")
    private String capital;
    private List<City> cities;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List getCities() {
        return cities;
    }

    public void setCities(List cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "--------------------\nCountry\n" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", climate=" + climate +
                ", capital='" + capital + '\'' +
                ", \n\ncities:\n" + getCitiesAsStr() +
                '}';
    }

    private String getCitiesAsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city.toString()).append("\n");
        }

        return stringBuilder.toString();
    }

    public String getAsStrWithoutCities() {
        return "id=" + id +
                "name='" + name + '\'' +
                ", climate=" + climate +
                ", capital='" + capital + '\'';
    }

}