package com.gojek.iavanish.services;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;

/**
 * Created by iavanish on 2019-08-20
 */
public interface ParkingLotService {

    void run() throws InvalidInputException, ParkingLotException;

}
