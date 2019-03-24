package common.business.exceptions;

public enum UncheckedExceptionCodes {

    USER_ADD(20, "Can't add this user"),
    USER_DELETE(40, "Can't delete this user"),
    ORDER_DELETE(60, "Can't delete this order"),
    CITY_DELETE(80, "Can't delete this city"),
    COUNTRY_DELETE(100, "Can't delete this country"),
    NO_SUCH_CSV_FILE(120, "Can't find such CSV file");

    private String message;
    private int code;

    UncheckedExceptionCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
