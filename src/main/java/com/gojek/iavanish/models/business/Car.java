package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.VehicleColour;

/**
 * Created by iavanish on 2019-08-20
 */
public class Car extends Vehicle {

    public Car(String registrationNumber, VehicleColour colour) {
        super(registrationNumber, colour);
    }

    @Override
    public String getVehicleType() {
        return "car";
    }

}
