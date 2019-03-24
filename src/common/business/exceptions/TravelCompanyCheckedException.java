package common.business.exceptions;

public class TravelCompanyCheckedException extends RuntimeException {

    protected int code;

    public TravelCompanyCheckedException(CheckedExceptionCodes exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }

    public TravelCompanyCheckedException(CheckedExceptionCodes exceptionCode, Exception cause) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
        initCause(cause);
    }
}


