package com.gojek.iavanish;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.util.constants.ParkingLotConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

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

    @Test
    public void mainSuccess() throws Exception {
        ParkingLotApplication.main("file", "functional_spec/fixtures/file_input.txt");
        assertTrue(compareFiles(new File("functional_spec/fixtures/file_input_expected_output.txt"), new File(ParkingLotConstants.OUTPUT_FILE)));
    }

    @Test(expected = InvalidInputException.class)
    public void mainFailureInvalidFile() throws Exception {
        ParkingLotApplication.main("file", "functional_spec/fixtures/no_file_here.txt");
    }

    @Test(expected = InvalidInputException.class)
    public void mainFailureWrongArguments() throws Exception {
        ParkingLotApplication.main("file", "functional_spec/fixtures/file_input_invalid_wrong_arguments.txt");
    }

    @Test(expected = InvalidInputException.class)
    public void mainFailureWrongCommand() throws Exception {
        ParkingLotApplication.main("file", "functional_spec/fixtures/file_input_invalid_wrong_command.txt");
    }

    private Boolean compareFiles(File file1, File file2) throws Exception {
        Scanner scanner1 = new Scanner(file1);
        Scanner scanner2 = new Scanner(file2);
        while(scanner1.hasNext() && scanner2.hasNext()) {
            if(!scanner1.nextLine().equals(scanner2.nextLine())) {
                return false;
            }
        }
        return !scanner1.hasNext() && !scanner2.hasNext();
    }

}
