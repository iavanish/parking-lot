package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.strategies.InputItemExecutionStrategyTest;
import com.gojek.iavanish.util.constants.ParkingLotConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by iavanish on 2019-08-21
 */
public class StatusStrategyTest extends InputItemExecutionStrategyTest {

    private CreateParkingLotStrategy createParkingLotStrategy;
    private ParkStrategy parkStrategy;
    private StatusStrategy statusStrategy;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createParkingLotStrategy = new CreateParkingLotStrategy();
        parkStrategy = new ParkStrategy();
        statusStrategy = new StatusStrategy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("2")));
        parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("KA-01-SOMETHING", "White"))).split("\\s+");
        parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("AK-10-ANOTHERONE", "Black"))).split("\\s+");
        String result = statusStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.status, Collections.emptyList()));
        assertThat(result, containsString("KA-01-SOMETHING"));
        assertThat(result, containsString("AK-10-ANOTHERONE"));
        assertThat(result, containsString("White"));
        assertThat(result, containsString("Black"));
    }

}