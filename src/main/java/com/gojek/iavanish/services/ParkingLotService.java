package com.gojek.iavanish.services;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;

import java.io.File;

/**
 * Created by iavanish on 2019-08-20
 */
public interface ParkingLotService {

    void run(File outputFile) throws InvalidInputException, ParkingLotException;

}
