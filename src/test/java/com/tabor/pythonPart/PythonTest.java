package com.tabor.pythonPart;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by marek on 06.11.2017.
 */
public class PythonTest {

    @Test
    public void wasRun(){
        WasRun wasRun = new WasRun();
        assertFalse(wasRun.wasRun);
        assertTrue(wasRun.run());
    }

    @Test
    public void testCaseTest(){
        WasRun wasRun = Mockito.mock(WasRun.class);
        Mockito.verify(wasRun, Mockito.times(0)).run();
        wasRun.run();
        Mockito.verify(wasRun, Mockito.times(1)).run();
    }
}
