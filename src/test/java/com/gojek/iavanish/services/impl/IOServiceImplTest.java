package com.gojek.iavanish.services.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by iavanish on 2019-08-20
 */
public class IOServiceImplTest {

    private IOServiceImpl ioService;

    @Before
    public void setUp() throws Exception {
        ioService = new IOServiceImpl("file", "functional_spec/fixtures/file_input.txt");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNextInput() throws Exception {
        ioService.getNextInput();
    }
}