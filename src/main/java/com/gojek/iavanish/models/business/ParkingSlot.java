package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.ParkingSlotAvailability;

/**
 * Created by iavanish on 2019-08-20
 */
public abstract class ParkingSlot {

    private Long id;
    private ParkingSlotAvailability availability;

    public ParkingSlot(Long id, ParkingSlotAvailability availability) {
        this.id = id;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingSlotAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(ParkingSlotAvailability availability) {
        this.availability = availability;
    }

}
