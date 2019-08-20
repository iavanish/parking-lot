package com.gojek.iavanish.models.io;

import com.gojek.iavanish.models.io.validations.InputType;

import java.util.Scanner;

/**
 * Created by iavanish on 2019-08-20
 */
public class InputSource {

    private InputType inputType;
    private Scanner scanner;

    public InputSource(InputType inputType, Scanner scanner) {
        this.inputType = inputType;
        this.scanner = scanner;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
