package com.gojek.iavanish;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.services.impl.IOServiceImpl;
import com.gojek.iavanish.services.impl.ParkingLotServiceImpl;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotApplication {

    public static void main(String... args) throws InvalidInputException, ParkingLotException {
        new ParkingLotServiceImpl(new IOServiceImpl(args)).run();
    }

}
