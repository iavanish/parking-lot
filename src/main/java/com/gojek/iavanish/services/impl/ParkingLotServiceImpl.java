package com.gojek.iavanish.services.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.models.constants.ParkingLotConstants;
import com.gojek.iavanish.models.io.InputLine;
import com.gojek.iavanish.services.IOService;
import com.gojek.iavanish.services.ParkingLotService;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotServiceImpl implements ParkingLotService {

    private final IOService ioService;

    public ParkingLotServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void run() throws InvalidInputException {
        while(true) {
            InputLine inputLine = ioService.getNextInput();
            if(ParkingLotConstants.appTerminationCommands.contains(inputLine.getCommand())) {
                System.exit(0);
            }
        }
    }

}
