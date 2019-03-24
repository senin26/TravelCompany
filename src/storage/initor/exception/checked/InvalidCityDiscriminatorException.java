package storage.initor.exception.checked;

import common.business.exceptions.TravelCompanyCheckedException;

public class InvalidCityDiscriminatorException extends TravelCompanyCheckedException {

    public InvalidCityDiscriminatorException(int code, String message) {
        super(code, message);
    }
}
