package com.gojek.iavanish.exceptions;

/**
 * Created by iavanish on 2019-08-20
 */
abstract class GenericException extends Exception {

    private String message;
    private int code;

    GenericException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
