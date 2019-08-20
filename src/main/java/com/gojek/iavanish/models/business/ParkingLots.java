package com.gojek.iavanish.models.business;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLots {

    private Map<String, ParkingLot> parkingLots;

    public ParkingLots() {
        parkingLots = new LinkedHashMap<>();
    }

    public Boolean parkingLotExists(String name) {
        return parkingLots.containsKey(name);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        if(!parkingLotExists(parkingLot.getName())) {
            parkingLots.put(parkingLot.getName(), parkingLot);
        }
    }

    public ParkingLot getParkingLot(String name) {
        return parkingLots.get(name);
    }

    public void setParkingLots(Map<String, ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

}
