package com.gojek.iavanish.exceptions;

/**
 * Created by iavanish on 2019-08-20
 */
public class InvalidInputException extends GenericException {

    public InvalidInputException(int code, String message) {
        super(code, message);
    }

}
