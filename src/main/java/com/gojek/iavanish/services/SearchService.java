package com.gojek.iavanish.services;

import com.gojek.iavanish.models.business.ParkingLot;
import com.gojek.iavanish.models.business.ParkingSlot;
import com.gojek.iavanish.models.business.SearchVehicleQuery;

import java.util.List;

/**
 * Created by iavanish on 2019-08-20
 */
public interface SearchService {

    List<ParkingSlot> findParkingSlotInfo(SearchVehicleQuery searchVehicleQuery, ParkingLot parkingLot);

}
