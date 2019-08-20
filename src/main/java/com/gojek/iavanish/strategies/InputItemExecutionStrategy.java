package com.gojek.iavanish.strategies;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;

/**
 * Created by iavanish on 2019-08-20
 */
public abstract class InputItemExecutionStrategy {

    protected Integer requiredNoOfArguments;

    public abstract void execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException;

    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        validateInputItemArgumentSize(inputItem);
    }

    private void validateInputItemArgumentSize(InputItem inputItem) throws InvalidInputException {
        if(inputItem == null || inputItem.getArguments() == null || inputItem.getArguments().size() != requiredNoOfArguments) {
            throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.INVALID_ARGUMENTS);
        }
    }

    protected void validateInputIsInteger(String input) throws InvalidInputException {
        try {
            Long.parseLong(input);
        }
        catch (NumberFormatException exception) {
            throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.INVALID_ARGUMENTS);
        }
    }

}
