package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;

/**
 * Created by iavanish on 2019-08-20
 */
public class ExitStrategy extends InputItemExecutionStrategy {

    public ExitStrategy() {
        requiredNoOfArguments = 0;
    }

    @Override
    public String execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        System.exit(0);
        return "";
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
    }
}
