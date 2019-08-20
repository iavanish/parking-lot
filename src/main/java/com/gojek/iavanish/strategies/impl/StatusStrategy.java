package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.business.validations.ParkingSlotAvailability;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;

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
    public String execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        ParkingLot parkingLot = parkingLots.getParkingLot(inputItem.getParkingLotName());
        List<ParkingSlot> parkingSlots = parkingLot.getParkingSlots().stream()
                .filter(parkingSlot -> parkingSlot.getAvailability().equals(ParkingSlotAvailability.occupied))
                .collect(Collectors.toList());
        if(parkingSlots.isEmpty()) {
            return "No parking slot is occupied right now";
        }
        return formatOutput(parkingSlots);
    }

    private String formatOutput(List<ParkingSlot> parkingSlots) {
        StringBuilder result = new StringBuilder("Slot No.    Registration No    Colour");
        parkingSlots.forEach(parkingSlot -> {
            StringBuilder slotNo = new StringBuilder(String.valueOf(parkingSlot.getId()));
            while(slotNo.length() < 12) {
                slotNo.append(" ");
            }
            StringBuilder registrationNo = new StringBuilder(parkingSlot.getVehicle().getRegistrationNumber());
            while (registrationNo.length() < 19) {
                registrationNo.append(" ");
            }
            result.append(String.format("\n%s%s%s", slotNo, registrationNo, parkingSlot.getVehicle().getColour().name()));
        });
        return result.toString();
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
    }

}
