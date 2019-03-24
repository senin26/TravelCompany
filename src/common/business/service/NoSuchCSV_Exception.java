package common.business.service;

import common.business.exceptions.TravelCompanyUncheckedException;
import common.business.exceptions.UncheckedExceptionCodes;
//todo delete this
public class NoSuchCSV_Exception extends TravelCompanyUncheckedException {
    public NoSuchCSV_Exception() {
        super(UncheckedExceptionCodes.NO_SUCH_CSV_FILE);
    }
}