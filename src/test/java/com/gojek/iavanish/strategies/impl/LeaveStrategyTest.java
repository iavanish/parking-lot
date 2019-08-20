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

import static org.hamcrest.core.Is.is;

/**
 * Created by iavanish on 2019-08-21
 */
public class LeaveStrategyTest extends InputItemExecutionStrategyTest {

    private CreateParkingLotStrategy createParkingLotStrategy;
    private ParkStrategy parkStrategy;
    private LeaveStrategy leaveStrategy;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createParkingLotStrategy = new CreateParkingLotStrategy();
        parkStrategy = new ParkStrategy();
        leaveStrategy = new LeaveStrategy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("1")));
        String[] newInsert = parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("KA-01-SOMETHING", "White"))).split("\\s+");
        Long id = Long.parseLong(newInsert[newInsert.length-1]);
        String result = leaveStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.leave, Collections.singletonList(String.valueOf(id))));
        Assert.assertThat(result, is(String.format("Slot number %d is free", id)));
    }

}