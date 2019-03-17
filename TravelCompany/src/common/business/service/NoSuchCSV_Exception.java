package common.business.service;

import common.business.exceptions.BasicTravelCompanyUncheckedException;
import common.business.exceptions.ExceptionCodes;

public class NoSuchCSV_Exception extends BasicTravelCompanyUncheckedException {
    public NoSuchCSV_Exception() {
        super(ExceptionCodes.NO_SUCH_CSV_FILE);
    }
}