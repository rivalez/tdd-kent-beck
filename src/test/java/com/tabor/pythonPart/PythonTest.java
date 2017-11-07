package com.tabor.pythonPart;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by marek on 06.11.2017.
 */
public class PythonTest {

    private TestCase test = new TestCase();

    @Before
    public void setUp() {
        test = new TestCase();
    }

    @Test
    public void wasRun(){
        assertFalse(test.wasRun);
    }

    @Test
        public void testCaseTest(){
        TestCase test = Mockito.mock(TestCase.class);
        Mockito.verify(test, Mockito.times(0)).run();
        test.run();
        Mockito.verify(test, Mockito.times(1)).run();
    }

    @Test
    public void testSetUp(){
        test.setUp();
        test.testMethod();
        assertTrue(test.log.equals("setUp testMethod "));
    }

    @Test
    public void testTemplateMethod(){
        test.testMethod();
        test.run();
        assertTrue(test.log.equals("setUp testMethod tearDown "));
    }

    @Test
    public void testResult() {
        test.testMethod();
        TestResult result = test.run();
        assertTrue("1 run, 0 failed".equals(result.summary()));
    }

    @Test
    public void testFailedResult() throws Exception {
        test.testBrokenMethod();
        TestResult result = test.run();
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    @Test
    public void testFailedResultFormatting() {
        TestResult result = test.run();
        result.testStarted();
        result.testFailed();
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

}
