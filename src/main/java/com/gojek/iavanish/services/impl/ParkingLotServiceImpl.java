package com.gojek.iavanish.services.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.services.IOService;
import com.gojek.iavanish.services.ParkingLotService;
import com.gojek.iavanish.services.SearchService;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;
import com.gojek.iavanish.strategies.InputItemExecutionStrategyFactory;
import com.gojek.iavanish.util.constants.ErrorCodes;
import com.gojek.iavanish.util.constants.ErrorMessages;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLotServiceImpl implements ParkingLotService {

    private final IOService ioService;
    private final ParkingLots parkingLots;
    private final SearchService searchService;
    private final InputItemExecutionStrategyFactory inputItemExecutionStrategyFactory;

    public ParkingLotServiceImpl(IOService ioService) {
        this.ioService = ioService;
        this.parkingLots = new ParkingLots();
        this.searchService = new SearchServiceImpl();
        this.inputItemExecutionStrategyFactory = new InputItemExecutionStrategyFactory(searchService);
    }

    @Override
    public void run(File outputFile) throws InvalidInputException, ParkingLotException {
        Path file = Paths.get(outputFile.getPath());
        while(true) {
            InputItem inputItem = ioService.getNextInput();
            InputItemExecutionStrategy executionStrategy = inputItemExecutionStrategyFactory.getStrategy(inputItem);
            String result = executionStrategy.execute(parkingLots, inputItem);
            try {
                Files.write(file, Collections.singletonList(result), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
            catch (IOException exception) {
                throw new ParkingLotException(ErrorCodes.OUTPUT_ERROR, ErrorMessages.UNABEL_TO_WRITE_TO_FILE);
            }
        }
    }

}
