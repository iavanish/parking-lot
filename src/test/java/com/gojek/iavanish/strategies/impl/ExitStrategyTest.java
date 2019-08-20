package com.gojek.iavanish.strategies.impl;

import com.gojek.iavanish.strategies.InputItemExecutionStrategyTest;
import org.junit.After;
import org.junit.Before;

/**
 * Created by iavanish on 2019-08-20
 */
public class ExitStrategyTest extends InputItemExecutionStrategyTest {

    private ExitStrategy exitStrategy;

    @Before
    public void setUp() throws Exception {
        exitStrategy = new ExitStrategy();
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
