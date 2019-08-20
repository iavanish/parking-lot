package com.gojek.iavanish.services.impl;

import com.gojek.iavanish.services.ParkingLotService;
import org.junit.After;
import org.junit.Before;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotServiceImplTest {

    private ParkingLotService parkingLotService;

    @Before
    public void setUp() throws Exception {
        parkingLotService = new ParkingLotServiceImpl(
                new IOServiceImpl("functional_spec/fixtures/file_input.txt"));
    }

    @After
    public void tearDown() throws Exception {
    }

}
