package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.strategies.InputItemExecutionStrategyTest;
import com.gojek.iavanish.util.constants.ParkingLotConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by iavanish on 2019-08-20
 */
public class CreateParkingLotStrategyTest extends InputItemExecutionStrategyTest {

    private CreateParkingLotStrategy createParkingLotStrategy;

    @Before
    public void setUp() throws Exception {
        createParkingLotStrategy = new CreateParkingLotStrategy();
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void execute() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("10")));
        assertTrue(parkingLots.parkingLotExists(ParkingLotConstants.PARKING_LOT_NAME));
        assertEquals(new Long(10), parkingLots.getParkingLot(ParkingLotConstants.PARKING_LOT_NAME).numberOfAvailableSlots());
    }

    @Test(expected = ParkingLotException.class)
    public void executeDuplicateCreation() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("10")));
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("5")));
    }

}