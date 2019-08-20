package com.gojek.iavanish.models.constants;

import com.gojek.iavanish.models.io.validations.InputCommand;

import java.util.Arrays;
import java.util.List;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotConstants {

    public static final List<InputCommand> appTerminationCommands = Arrays.asList(InputCommand.exit, InputCommand.end_of_line);

}
