package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.models.io.InputItem;
import com.gojek.iavanish.models.io.validations.InputCommand;
import com.gojek.iavanish.strategies.InputItemExecutionStrategyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

/**
 * Created by iavanish on 2019-08-20
 */
public class EndOfLineStrategyTest extends InputItemExecutionStrategyTest {

    private EndOfLineStrategy endOfLineStrategy;

    @Before
    public void setUp() throws Exception {
        endOfLineStrategy = new EndOfLineStrategy();
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void execute() throws Exception {
        endOfLineStrategy.execute(parkingLots, new InputItem(InputCommand.end_of_line, Collections.emptyList()));
    }

}