package com.gojek.iavanish;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.services.impl.IOServiceImpl;
import com.gojek.iavanish.services.impl.ParkingLotServiceImpl;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;
import com.gojek.iavanish.util.constants.ParkingLotConstants;

import java.io.File;
import java.io.IOException;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotApplication {

    public static void main(String... args) throws InvalidInputException, ParkingLotException {
        File outputFile = new File(ParkingLotConstants.OUTPUT_FILE);
        try {
            outputFile.createNewFile();
        }
        catch (IOException exception) {
            throw new ParkingLotException(ErrorCodes.OUTPUT_ERROR, ErrorMessages.UNABEL_TO_WRITE_TO_FILE);
        }
        new ParkingLotServiceImpl(new IOServiceImpl(args)).run(outputFile);
    }

}
