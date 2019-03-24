package city.search;

public class SmallCitySearchCondition {

    private Boolean hasHospital;
    private Boolean hasRailwayStation;

    public boolean searchByHasHospital() {
        return hasHospital != null;
    }

    public boolean searchByHasRailwayStation() {
        return hasRailwayStation != null;
    }

    public Boolean hasHospital() {
        return hasHospital;
    }

    public void setHasHospital(Boolean hasHospital) {
        this.hasHospital = hasHospital;
    }

    public Boolean hasRailwayStation() {
        return hasRailwayStation;
    }

    public void setHasRailwayStation(Boolean hasRailwayStation) {
        this.hasRailwayStation = hasRailwayStation;
    }

}
