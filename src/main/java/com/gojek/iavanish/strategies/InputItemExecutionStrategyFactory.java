package com.gojek.iavanish.strategies;

import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.services.SearchService;
import com.gojek.iavanish.strategies.impl.*;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iavanish on 2019-08-20
 */
public class InputItemExecutionStrategyFactory {

    private final Map<InputCommand, InputItemExecutionStrategy> inputItemExecutionStrategies;

    public InputItemExecutionStrategyFactory(SearchService searchService) {
        inputItemExecutionStrategies = new HashMap<>();
        inputItemExecutionStrategies.put(InputCommand.create_parking_lot, new CreateParkingLotStrategy());
        inputItemExecutionStrategies.put(InputCommand.leave, new LeaveStrategy());
        inputItemExecutionStrategies.put(InputCommand.park, new ParkStrategy());
        inputItemExecutionStrategies.put(InputCommand.status, new StatusStrategy());
        inputItemExecutionStrategies.put(InputCommand.registration_numbers_for_cars_with_colour, new RegistrationNumbersForCarsWithColourStrategy(searchService));
        inputItemExecutionStrategies.put(InputCommand.slot_numbers_for_cars_with_colour, new SlotNumbersForCarsWithColourStrategy(searchService));
        inputItemExecutionStrategies.put(InputCommand.slot_number_for_registration_number, new SlotNumberForRegistrationNumberStrategy(searchService));
        inputItemExecutionStrategies.put(InputCommand.exit, new ExitStrategy());
        inputItemExecutionStrategies.put(InputCommand.end_of_line, new EndOfLineStrategy());
    }

    public InputItemExecutionStrategy getStrategy(InputItem inputItem) throws ParkingLotException {
        if(!inputItemExecutionStrategies.containsKey(inputItem.getCommand())) {
            throw new ParkingLotException(ErrorCodes.NOT_FOUND, ErrorMessages.STRATEGY_NOT_FOUND);
        }
        return inputItemExecutionStrategies.get(inputItem.getCommand());
    }

}
