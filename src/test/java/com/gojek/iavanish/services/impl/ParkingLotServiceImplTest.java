package com.gojek.iavanish.services.impl;

import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.services.ParkingLotService;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;
import com.gojek.iavanish.util.constants.ParkingLotConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotServiceImplTest {

    private ParkingLotService parkingLotService;

    @Before
    public void setUp() throws Exception {
        parkingLotService = new ParkingLotServiceImpl(
                new IOServiceImpl("file", "functional_spec/fixtures/file_input.txt"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() throws Exception {
        File outputFile = new File(ParkingLotConstants.OUTPUT_FILE);
        try {
            outputFile.createNewFile();
        }
        catch (IOException exception) {
            throw new ParkingLotException(ErrorCodes.OUTPUT_ERROR, ErrorMessages.UNABEL_TO_WRITE_TO_FILE);
        }
        parkingLotService.run(outputFile);
    }

}
