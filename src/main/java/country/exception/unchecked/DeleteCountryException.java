package country.exception.unchecked;

import common.business.exceptions.TravelCompanyUncheckedException;
import country.exception.CountryExceptionMeta;

public class DeleteCountryException extends TravelCompanyUncheckedException {

    public DeleteCountryException(int code, String message) {
        super(code, message);
    }

    public DeleteCountryException(CountryExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
