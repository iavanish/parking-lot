package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.business.validations.ParkingSlotAvailability;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;
import com.gojek.iavanish.util.constants.ParkingLotConstants;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iavanish on 2019-08-20
 */
public class StatusStrategy extends InputItemExecutionStrategy {

    public StatusStrategy() {
        requiredNoOfArguments = 0;
    }

    @Override
    public void execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        ParkingLot parkingLot = parkingLots.getParkingLot(ParkingLotConstants.PARKING_LOT_NAME);
        List<ParkingSlot> parkingSlots = parkingLot.getParkingSlots().stream()
                .filter(parkingSlot -> parkingSlot.getAvailability().equals(ParkingSlotAvailability.occupied))
                .collect(Collectors.toList());
        if(parkingSlots == null || parkingSlots.isEmpty()) {
            System.out.println("No parking slot is occupied right now\n");
        }
        else {
            System.out.printf("Slot No.\tRegistration No.\tColour\n");
            parkingSlots.forEach(parkingSlot -> System.out.printf("%s\t%s\t%s\n", parkingSlot.getId(),
                    parkingSlot.getVehicle().getRegistrationNumber(), parkingSlot.getVehicle().getColour().name()));
        }
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
    }

}
