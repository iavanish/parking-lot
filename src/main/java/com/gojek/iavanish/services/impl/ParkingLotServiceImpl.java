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
    public void run() throws InvalidInputException, ParkingLotException {
        while(true) {
            InputItem inputItem = ioService.getNextInput();
            InputItemExecutionStrategy executionStrategy = inputItemExecutionStrategyFactory.getStrategy(inputItem);
            executionStrategy.execute(parkingLots, inputItem);
        }
    }

}
