package city.search;

public class BigCitySearchCondition extends CitySearchCondition {

    private Boolean hasLocalEmbassy;
    private Boolean hasDirectFlights;
    private Boolean hasMetro;


    public boolean searchByHasLocalEmbassy() {
        return hasLocalEmbassy != null;
    }

    public boolean searchByHasDirectFlights() {
        return hasDirectFlights != null;
    }

    public boolean searchByHasMetro() {
        return hasMetro != null;
    }

    public Boolean hasMetro() {
        return hasMetro;
    }

    public void setHasMetro(Boolean hasMetro) {
        this.hasMetro = hasMetro;
    }

    public Boolean hasDirectFlights() {
        return hasDirectFlights;
    }

    public void setHasDirectFlights(Boolean hasDirectFlights) {
        this.hasDirectFlights = hasDirectFlights;
    }

    public Boolean hasLocalEmbassy() {
        return hasLocalEmbassy;
    }

    public void setHasLocalEmbassy(Boolean hasLocalEmbassy) {
        this.hasLocalEmbassy = hasLocalEmbassy;
    }


}
