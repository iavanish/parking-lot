package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.services.impl.SearchServiceImpl;
import com.gojek.iavanish.strategies.InputItemExecutionStrategyTest;
import com.gojek.iavanish.util.constants.ParkingLotConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by iavanish on 2019-08-21
 */
public class SlotNumbersForCarsWithColourStrategyTest extends InputItemExecutionStrategyTest {

    private CreateParkingLotStrategy createParkingLotStrategy;
    private ParkStrategy parkStrategy;
    private SlotNumbersForCarsWithColourStrategy slotNumbersForCarsWithColourStrategy;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createParkingLotStrategy = new CreateParkingLotStrategy();
        parkStrategy = new ParkStrategy();
        slotNumbersForCarsWithColourStrategy = new SlotNumbersForCarsWithColourStrategy(new SearchServiceImpl());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("1")));
        String[] newInsert = parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("KA-01-SOMETHING", "White"))).split("\\s+");
        Long id = Long.parseLong(newInsert[newInsert.length-1]);
        String result = slotNumbersForCarsWithColourStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.slot_numbers_for_cars_with_colour, Collections.singletonList("White")));
        assertThat(result, is(String.valueOf(id)));
    }

    @Test
    public void executeNotFound() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("1")));
        String result = slotNumbersForCarsWithColourStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.slot_numbers_for_cars_with_colour, Collections.singletonList("White")));
        assertThat(result, is("Not found"));
    }

}