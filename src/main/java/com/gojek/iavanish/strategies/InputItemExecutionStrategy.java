package com.gojek.iavanish.strategies;

import com.gojek.iavanish.models.business.ParkingLots;
import com.gojek.iavanish.models.io.InputItem;

/**
 * Created by iavanish on 2019-08-20
 */
public abstract class InputItemExecutionStrategy {

    public abstract void execute(ParkingLots parkingLots, InputItem inputItem);

}
