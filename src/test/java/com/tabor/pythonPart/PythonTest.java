package com.tabor.pythonPart;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by marek on 06.11.2017.
 */
public class PythonTest {

    private WasRun wasRun = new WasRun();

    @Before
    public void setUp() {
        wasRun = new WasRun();
    }

    @Test
    public void wasRun(){
        assertFalse(wasRun.wasRun);
    }

    @Test
        public void testCaseTest(){
        WasRun wasRun = Mockito.mock(WasRun.class);
        Mockito.verify(wasRun, Mockito.times(0)).run();
        wasRun.run();
        Mockito.verify(wasRun, Mockito.times(1)).run();
    }

    @Test
    public void testSetUp(){
        wasRun.setUp();
        wasRun.testMethod();
        assertTrue(wasRun.log.equals("setUp testMethod "));
    }

    @Test
    public void testTemplateMethod(){
        wasRun.testMethod();
        wasRun.run();
        assertTrue(wasRun.log.equals("setUp testMethod tearDown "));
    }
}
