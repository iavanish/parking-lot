package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.ParkingSlotAvailability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by iavanish on 2019-08-20
 */
public class ParkingLot {

    private String id;
    private String name;
    private final List<ParkingSlot> parkingSlots;
    private Long maxCapacity;

    public ParkingLot(String name, Long maxCapacity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.parkingSlots = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        for(Long i = 0L; i < maxCapacity; i++) {
            parkingSlots.add(new CarParkingSlot(i+1));
        }
    }

    public Long numberOfAvailableSlots() {
        return parkingSlots.stream()
                .filter(parkingSlot -> parkingSlot.getAvailability().equals(ParkingSlotAvailability.available)).count();
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

    public Long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<ParkingSlot> getAvailableSlots(int noOfSlots) {
        List<ParkingSlot> availableSlots = parkingSlots.stream().filter(parkingSlot -> parkingSlot.getAvailability().equals(ParkingSlotAvailability.available)).collect(Collectors.toList());
        if(noOfSlots <= availableSlots.size()) {
            return availableSlots.subList(0, noOfSlots);
        }
        return Collections.emptyList();
    }
}
