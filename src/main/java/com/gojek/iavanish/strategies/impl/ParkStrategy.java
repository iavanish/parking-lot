package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.Car;
import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.business.validations.VehicleColour;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;

import java.util.List;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkStrategy extends InputItemExecutionStrategy {

    public ParkStrategy() {
        requiredNoOfArguments = 2;
    }

    @Override
    public String execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        ParkingLot parkingLot = parkingLots.getParkingLot(inputItem.getParkingLotName());
        if(parkingLot.numberOfAvailableSlots() < 1) {
            return "Sorry, parking lot is full";
        }
        else {
            String registrationNumber = inputItem.getArguments().get(0);
            VehicleColour colour = VehicleColour.valueOf(inputItem.getArguments().get(1));
            Car car = new Car(registrationNumber, colour);
            List<ParkingSlot> parkingSlot = parkingLot.getAvailableSlots(1);
            parkingSlot.get(0).assignVehicle(car);
            return String.format("Allocated slot number: %d", parkingSlot.get(0).getId());
        }
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
        try {
            VehicleColour.valueOf(inputItem.getArguments().get(1));
        }
        catch (IllegalArgumentException exception) {
            throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.INVALID_VEHICLE_COLOUR);
        }
    }

}
