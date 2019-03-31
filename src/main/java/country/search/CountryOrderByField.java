package country.search;

public enum CountryOrderByField {
    CLIMATE("countryclimate"),NAME("countryname");

    CountryOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
