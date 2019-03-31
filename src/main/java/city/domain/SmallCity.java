package city.domain;

public class SmallCity extends City {

    @Override
    protected void initDiscriminator() {
        discriminator = CityDiscriminator.SMALL_CITY;
    }

    private boolean hasHospital;
    private boolean hasRailwayStation;

    public boolean hasHospital() {
        return hasHospital;
    }

    public void setHasHospital(boolean hasHospital) {
        this.hasHospital = hasHospital;
    }

    public boolean hasRailwayStation() {
        return hasRailwayStation;
    }

    public void setHasRailwayStation(boolean hasRailwayStation) {
        this.hasRailwayStation = hasRailwayStation;
    }
}
