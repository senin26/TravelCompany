package city.domain.exception;

public enum CityExceptionMeta {

    DELETE_CITY_CONSTRAINT_ERROR(1, "Error while delete model. There is constraint violation!");

    private int code;
    private String description;

    CityExceptionMeta(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
