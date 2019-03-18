package user.service.exceptions;

import common.business.exceptions.BasicTravelCompanyUncheckedException;
import common.business.exceptions.ExceptionCodes;

public class UserAddException extends BasicTravelCompanyUncheckedException {

    public UserAddException() {
        super(ExceptionCodes.USER_ADD);
    }
}
