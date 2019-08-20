package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;
import com.gojek.iavanish.util.constants.ParkingLotConstants;

import java.util.List;
import java.util.Optional;

/**
 * Created by iavanish on 2019-08-20
 */
public class LeaveStrategy extends InputItemExecutionStrategy {

    public LeaveStrategy() {
        requiredNoOfArguments = 1;
    }

    @Override
    public void execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        ParkingLot parkingLot = parkingLots.getParkingLot(ParkingLotConstants.PARKING_LOT_NAME);
        List<ParkingSlot> parkingSlots = parkingLot.getParkingSlots();
        Long parkingSlotNumber = Long.parseLong(inputItem.getArguments().get(0));
        Optional<ParkingSlot> parkingSlot = parkingSlots.stream().filter(p -> p.getId().equals(parkingSlotNumber)).findFirst();
        if(parkingSlot.isPresent()) {
            parkingSlot.get().freeUpSlot();
        }
        else {
            throw new InvalidInputException(ErrorCodes.NOT_FOUND, ErrorMessages.INVALID_PARKING_SLOT_NUMBER);
        }
        System.out.printf("Slot number %d is free\n", parkingSlot.get().getId());
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
        validateInputIsInteger(inputItem.getArguments().get(0));
    }

}
