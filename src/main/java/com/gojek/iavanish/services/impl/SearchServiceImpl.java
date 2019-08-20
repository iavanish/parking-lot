package com.gojek.iavanish.services.impl;

import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.business.SearchVehicleQuery;
import com.gojek.iavanish.models.business.validations.SearchVehicleFields;
import com.gojek.iavanish.services.SearchService;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by iavanish on 2019-08-20
 */
public class SearchServiceImpl implements SearchService {

    @Override
    public List<ParkingSlot> findParkingSlotInfo(SearchVehicleQuery searchVehicleQuery, ParkingLot parkingLot) {
        List<ParkingSlot> parkingSlots = parkingLot.getParkingSlots();
        for(SearchVehicleFields searchVehicleField : SearchVehicleFields.values()) {
            if(searchVehicleQuery.getSearchVehicleFields().containsKey(searchVehicleField)) {
                parkingSlots = applySearchField(parkingSlots, searchVehicleField, searchVehicleQuery.getSearchVehicleFields().get(searchVehicleField));
            }
        }
        return parkingSlots;
    }

    private List<ParkingSlot> applySearchField(List<ParkingSlot> parkingSlots, SearchVehicleFields searchVehicleField, Set<String> values) {
        switch (searchVehicleField) {
            case vehicle_type:
                return parkingSlots.stream().filter(
                        parkingSlot -> parkingSlot.getVehicle() != null && values.contains(parkingSlot.getVehicle().getVehicleType())).collect(Collectors.toList());
            case registration_number:
                return parkingSlots.stream().filter(
                        parkingSlot -> parkingSlot.getVehicle() != null && values.contains(parkingSlot.getVehicle().getRegistrationNumber())).collect(Collectors.toList());
            case colour:
                return parkingSlots.stream().filter(
                        parkingSlot -> parkingSlot.getVehicle() != null && values.contains(parkingSlot.getVehicle().getColour().name())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
