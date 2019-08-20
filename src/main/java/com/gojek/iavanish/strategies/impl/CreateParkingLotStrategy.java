package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;
import com.gojek.iavanish.util.constants.ParkingLotConstants;

/**
 * Created by iavanish on 2019-08-20
 */
public class CreateParkingLotStrategy extends InputItemExecutionStrategy {

    public CreateParkingLotStrategy() {
        requiredNoOfArguments = 1;
    }

    @Override
    public void execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        if(parkingLots.parkingLotExists(ParkingLotConstants.PARKING_LOT_NAME)) {
            throw new ParkingLotException(ErrorCodes.DUPLICATE_PARKING_LOT, ErrorMessages.DUPLICATE_PARKING_LOT);
        }
        parkingLots.addParkingLot(new ParkingLot(ParkingLotConstants.PARKING_LOT_NAME, Long.parseLong(inputItem.getArguments().get(0))));
        System.out.printf("Created a parking lot with %d slots\n", Long.parseLong(inputItem.getArguments().get(0)));
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
        validateInputIsInteger(inputItem.getArguments().get(0));
    }

}
