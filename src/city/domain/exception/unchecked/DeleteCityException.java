package city.domain.exception.unchecked;


import city.domain.exception.CityExceptionMeta;
import common.business.exceptions.TravelCompanyUncheckedException;

public class DeleteCityException extends TravelCompanyUncheckedException {

    public DeleteCityException(int code, String message) {
        super(code, message);
    }

    public DeleteCityException(CityExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
