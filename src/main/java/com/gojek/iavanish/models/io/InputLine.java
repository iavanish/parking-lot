package com.gojek.iavanish.models.io;

import com.gojek.iavanish.models.io.validations.InputCommand;

import java.util.List;

/**
 * Created by iavanish on 2019-08-20
 */
public class InputLine {

    private InputCommand command;
    private List<String> arguments;

    public InputLine(InputCommand command, List<String> arguments) {
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

}
