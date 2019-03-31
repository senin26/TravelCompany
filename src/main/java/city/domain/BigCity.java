package city.domain;

public class BigCity extends City {

    private boolean hasLocalEmbassy;
    private boolean hasDirectFlights;
    private boolean hasMetro;

    @Override
    protected void initDiscriminator() {
        discriminator = CityDiscriminator.BIG_CITY;
    }

    public boolean hasMetro() {
        return hasMetro;
    }

    public void setHasMetro(boolean hasMetro) {
        this.hasMetro = hasMetro;
    }

    public boolean hasDirectFlights() {
        return hasDirectFlights;
    }

    public void setHasDirectFlights(boolean hasDirectFlights) {
        this.hasDirectFlights = hasDirectFlights;
    }

    public boolean hasLocalEmbassy() {
        return hasLocalEmbassy;
    }

    public void setHasLocalEmbassy(boolean hasLocalEmbassy) {
        this.hasLocalEmbassy = hasLocalEmbassy;
    }
}
