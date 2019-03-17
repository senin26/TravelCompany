package common.business.exceptions;

public enum ExceptionCodes {

    USER_ADD(20, "Can't add this user"),
    USER_DELETE(40, "Can't delete this user"),
    ORDER_DELETE(60, "Can't delete this order"),
    CITY_DELETE(80, "Can't delete this city"),
    COUNTRY_DELETE(100, "Can't delete this country");

    private String message;
    private int code;

    ExceptionCodes(int code, String message) {
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
