package com.gojek.iavanish.services.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.InputSource;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.models.io.validations.InputType;
import com.gojek.iavanish.services.IOService;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;
import com.gojek.iavanish.util.constants.ParkingLotConstants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iavanish on 2019-08-20
 */
public class IOServiceImpl implements IOService {

    private InputSource inputSource;

    private IOServiceImpl() {
    }

    public IOServiceImpl(String... args) throws InvalidInputException {
        InputType inputType = determineInputType(args);
        if(inputType.equals(InputType.command_line)) {
            inputSource = new InputSource(inputType, new Scanner(System.in));
        }
        else if(inputType.equals(InputType.file)) {
            try {
                inputSource = new InputSource(inputType, new Scanner(new File(args[0])));
            }
            catch (IOException exception) {
                throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.UNABLE_TO_READ_FILE);
            }
        }
        else {
            throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.UNKNOWN_INPUT_TYPE);
        }
    }

    @Override
    public InputItem getNextInput() throws InvalidInputException {
        if(inputSource.getScanner().hasNext()) {
            String[] line = inputSource.getScanner().nextLine().split("\\s+");
            try {
                InputCommand command = InputCommand.valueOf(line[0]);
                List<String> arguments = new ArrayList<>();
                if(!command.equals(InputCommand.exit) && !command.equals(InputCommand.status)) {
                    arguments.add(line[1]);
                    if (command.equals(InputCommand.park)) {
                        arguments.add(line[2]);
                    }
                }
                return generateInputItem(command, arguments);
            }
            catch (IllegalArgumentException exception) {
                throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.INVALID_INPUT_COMMAND);
            }
            catch (ArrayIndexOutOfBoundsException excpetion) {
                throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.INVALID_ARGUMENTS);
            }
        }
        else if(inputSource.getInputType().equals(InputType.file)) {
            return generateInputItem(InputCommand.end_of_line, new ArrayList<>());
        }
        throw new InvalidInputException(ErrorCodes.INVALID_INPUT, ErrorMessages.INVALID_INPUT_COMMAND);
    }

    private InputItem generateInputItem(InputCommand inputCommand, List<String> arguments) {
        return new InputItem(ParkingLotConstants.PARKING_LOT_NAME, inputCommand, arguments);
    }

    private InputType determineInputType(String... args) throws InvalidInputException {
        if(args != null && args.length == 1) {
            return InputType.file;
        }
        return InputType.command_line;
    }

    private boolean validateProgramArguments(String... args) {
        return args == null || args.length <= 1;
    }

}
