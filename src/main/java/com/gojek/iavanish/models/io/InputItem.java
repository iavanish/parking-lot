package com.gojek.iavanish.models.io;

import com.gojek.iavanish.models.io.validations.InputCommand;

import java.util.List;

/**
 * Created by iavanish on 2019-08-20
 */
public class InputItem {

    private String parkingLotName;
    private InputCommand command;
    private List<String> arguments;

    public InputItem(String parkingLotName, InputCommand command, List<String> arguments) {
        this.parkingLotName = parkingLotName;
        this.command = command;
        this.arguments = arguments;
    }

    public InputCommand getCommand() {
        return command;
    }

    public void setCommand(InputCommand command) {
        this.command = command;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

}
