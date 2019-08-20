package com.gojek.iavanish.services;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.models.io.InputLine;

/**
 * Created by iavanish on 2019-08-20
 */
public interface IOService {

    InputLine getNextInput() throws InvalidInputException;

}
