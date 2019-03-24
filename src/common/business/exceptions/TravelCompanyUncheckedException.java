package common.business.exceptions;

public class TravelCompanyUncheckedException extends RuntimeException {

    int code;

    public TravelCompanyUncheckedException(UncheckedExceptionCodes exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }
}
