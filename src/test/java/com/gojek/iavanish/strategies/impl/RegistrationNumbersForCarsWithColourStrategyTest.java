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
public class RegistrationNumbersForCarsWithColourStrategyTest extends InputItemExecutionStrategyTest {

    private CreateParkingLotStrategy createParkingLotStrategy;
    private ParkStrategy parkStrategy;
    private RegistrationNumbersForCarsWithColourStrategy registrationNumbersForCarsWithColourStrategy;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createParkingLotStrategy = new CreateParkingLotStrategy();
        parkStrategy = new ParkStrategy();
        registrationNumbersForCarsWithColourStrategy = new RegistrationNumbersForCarsWithColourStrategy(new SearchServiceImpl());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("1")));
        parkStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.park, Arrays.asList("KA-01-SOMETHING", "White"))).split("\\s+");
        String result = registrationNumbersForCarsWithColourStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.registration_numbers_for_cars_with_colour, Collections.singletonList("White")));
        assertThat(result, is("KA-01-SOMETHING"));
    }

    @Test
    public void executeNotFound() throws Exception {
        createParkingLotStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.create_parking_lot, Collections.singletonList("1")));
        String result = registrationNumbersForCarsWithColourStrategy.execute(parkingLots, new InputItem(ParkingLotConstants.PARKING_LOT_NAME, InputCommand.registration_numbers_for_cars_with_colour, Collections.singletonList("White")));
        assertThat(result, is("Not found"));
    }

}