package city.domain;

import common.business.domain.BaseDomain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class City extends BaseDomain<Long> {

    @XmlElement(name="name")
    protected String name;
    protected String description;
    protected String countryName;
    protected Long countryID;
    @XmlElement(name="population")
    protected int population;
    protected CityDiscriminator discriminator;

    public City() {
        initDiscriminator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public CityDiscriminator getDiscriminator() {
        return discriminator;
    }

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    protected abstract void initDiscriminator();

    @Override
    public String toString() {
        return discriminator +
                " id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", countryName='" + countryName + '\'' +
                ", population=" + population +
                '}';
    }
}