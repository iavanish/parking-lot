package com.gojek.iavanish.services;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.models.io.InputItem;

/**
 * Created by iavanish on 2019-08-20
 */
public interface IOService {

    InputItem getNextInput() throws InvalidInputException;

}
