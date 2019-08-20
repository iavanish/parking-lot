package com.gojek.iavanish;

import com.gojek.iavanish.exceptions.InvalidInputException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotApplicationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = InvalidInputException.class)
    public void mainFailureInvalidFile() throws Exception {
        ParkingLotApplication.main("functional_spec/fixtures/no_file_here.txt");
    }

    @Test(expected = InvalidInputException.class)
    public void mainFailureWrongArguments() throws Exception {
        ParkingLotApplication.main("functional_spec/fixtures/file_input_invalid_wrong_arguments.txt");
    }

    @Test(expected = InvalidInputException.class)
    public void mainFailureWrongCommand() throws Exception {
        ParkingLotApplication.main("functional_spec/fixtures/file_input_invalid_wrong_command.txt");
    }

}
