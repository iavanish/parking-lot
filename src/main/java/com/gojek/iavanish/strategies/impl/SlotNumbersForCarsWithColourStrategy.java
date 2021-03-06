package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.exceptions.InvalidInputException;
import com.gojek.iavanish.exceptions.ParkingLotException;
import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.business.SearchVehicleQuery;
import com.gojek.iavanish.models.business.validations.SearchVehicleFields;
import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.services.SearchService;
import com.gojek.iavanish.strategies.InputItemExecutionStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iavanish on 2019-08-20
 */
public class SlotNumbersForCarsWithColourStrategy extends InputItemExecutionStrategy {

    private final SearchService searchService;

    public SlotNumbersForCarsWithColourStrategy(SearchService searchService) {
        this.searchService = searchService;
        requiredNoOfArguments = 1;
    }

    @Override
    public String execute(ParkingLots parkingLots, InputItem inputItem) throws InvalidInputException, ParkingLotException {
        validateInputItem(inputItem);
        ParkingLot parkingLot = parkingLots.getParkingLot(inputItem.getParkingLotName());
        SearchVehicleQuery searchVehicleQuery = getSearchVehicleQuery(inputItem);
        List<ParkingSlot> parkingSlots = searchService.findParkingSlotInfo(searchVehicleQuery, parkingLot);
        if(parkingSlots == null || parkingSlots.isEmpty()) {
            return "Not found";
        }
        return parkingSlots
                .stream()
                .map(parkingSlot -> String.valueOf(parkingSlot.getId()))
                .collect(Collectors.joining(", "));
    }

    private SearchVehicleQuery getSearchVehicleQuery(InputItem inputItem) {
        SearchVehicleQuery searchVehicleQuery = new SearchVehicleQuery(new HashMap<>());
        searchVehicleQuery.getSearchVehicleFields().put(
                SearchVehicleFields.vehicle_type, new HashSet<>(Collections.singletonList("car")));
        searchVehicleQuery.getSearchVehicleFields().put(
                SearchVehicleFields.colour, new HashSet<>(Collections.singletonList(inputItem.getArguments().get(0))));
        return searchVehicleQuery;
    }

    @Override
    public void validateInputItem(InputItem inputItem) throws InvalidInputException {
        super.validateInputItem(inputItem);
    }

}
