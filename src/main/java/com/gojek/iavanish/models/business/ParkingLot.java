package com.gojek.iavanish.models.business;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLot {

    private String id;
    private String name;
    private final List<ParkingSlot> parkingSlots;
    private Integer maxCapacity;

    public ParkingLot(String name, Integer maxCapacity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.parkingSlots = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public Boolean isSpaceAvailable() {
        return maxCapacity < parkingSlots.size();
    }

    public Boolean addSlot(ParkingSlot parkingSlot) {
        if(maxCapacity != parkingSlots.size()) {
            return parkingSlots.add(parkingSlot);
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

}
