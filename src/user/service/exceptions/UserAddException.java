package user.service.exceptions;

import common.business.exceptions.TravelCompanyUncheckedException;
import common.business.exceptions.UncheckedExceptionCodes;

public class UserAddException extends TravelCompanyUncheckedException {

    public UserAddException() {
        super(UncheckedExceptionCodes.USER_ADD);
    }
}
