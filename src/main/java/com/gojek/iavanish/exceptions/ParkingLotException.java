package com.gojek.iavanish.exceptions;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotException extends GenericException {

    public ParkingLotException(int code, String message) {
        super(code, message);
    }

}