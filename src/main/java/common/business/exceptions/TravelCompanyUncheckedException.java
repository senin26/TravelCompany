package common.business.exceptions;

public class TravelCompanyUncheckedException extends RuntimeException {

    protected int code;

    public TravelCompanyUncheckedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public TravelCompanyUncheckedException(int code, String message, Exception cause) {
        super(message);
        this.code = code;
        initCause(cause);
    }
}
