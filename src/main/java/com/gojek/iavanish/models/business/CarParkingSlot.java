package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.ParkingSlotAvailability;

/**
 * Created by iavanish on 2019-08-20
 */
public class CarParkingSlot extends ParkingSlot {

    public CarParkingSlot(Long id, ParkingSlotAvailability availability) {
        super(id, availability);
    }

}
