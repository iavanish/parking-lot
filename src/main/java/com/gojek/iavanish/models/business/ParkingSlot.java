package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.ParkingSlotAvailability;

/**
 * Created by iavanish on 2019-08-20
 */
public abstract class ParkingSlot {

    private Long id;
    private ParkingSlotAvailability availability;
    private Vehicle vehicle;

    public ParkingSlot(Long id) {
        this.id = id;
        this.availability = ParkingSlotAvailability.available;
        this.vehicle = null;
    }

    public void freeUpSlot() {
        if(availability.equals(ParkingSlotAvailability.occupied)) {
            availability = ParkingSlotAvailability.available;
            vehicle = null;
        }
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

    public void assignVehicle(Vehicle vehicle) {
        if(availability.equals(ParkingSlotAvailability.available)) {
            availability = ParkingSlotAvailability.occupied;
            this.vehicle = vehicle;
        }
    }

    public void setAvailability(ParkingSlotAvailability availability) {
        this.availability = availability;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
