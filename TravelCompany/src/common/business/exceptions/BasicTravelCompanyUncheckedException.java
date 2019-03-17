package common.business.exceptions;

public class BasicTravelCompanyUncheckedException extends RuntimeException {

    int code;

    public BasicTravelCompanyUncheckedException(ExceptionCodes exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }
}
