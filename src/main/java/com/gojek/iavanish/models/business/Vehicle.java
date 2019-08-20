package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.VehicleColour;

/**
 * Created by iavanish on 2019-08-20
 */
public abstract class Vehicle {

    private String registrationNumber;
    private VehicleColour colour;

    public Vehicle(String registrationNumber, VehicleColour colour) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleColour getColour() {
        return colour;
    }

    public void setColour(VehicleColour colour) {
        this.colour = colour;
    }

    public abstract String getVehicleType();

}
