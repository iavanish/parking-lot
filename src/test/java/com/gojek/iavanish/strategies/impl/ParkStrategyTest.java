package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.strategies.InputItemExecutionStrategyTest;
import com.gojek.iavanish.util.constants.ParkingLotConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by iavanish on 2019-08-21
 */
public class ParkStrategyTest extends InputItemExecutionStrategyTest {

    private CreateParkingLotStrategy createParkingLotStrategy;
    private ParkStrategy parkStrategy;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createParkingLotStrategy = new CreateParkingLotStrategy();
        parkStrategy = new ParkStrategy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("1")));
        String result = parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("KA-01-SOMETHING", "White")));
        Assert.assertThat(result, containsString(String.format("Allocated slot number: ")));
    }

    @Test
    public void executeFailDueToOverflow() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("0")));
        String result = parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("KA-01-SOMETHING", "White")));
        Assert.assertThat(result, is("Sorry, parking lot is full"));
    }

}
