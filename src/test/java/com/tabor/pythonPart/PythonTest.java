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

    private TestCase test = new TestCase();

    @Before
    public void setUp() {
        test = new TestCase();
    }

    @Test
    public void wasRun() {
        assertFalse(test.wasRun);
    }

    @Test
    public void testCaseTest() {
        TestCase test = Mockito.mock(TestCase.class);
        TestResult result = new TestResult();
        Mockito.verify(test, Mockito.times(0)).run(result);
        test.run(result);
        Mockito.verify(test, Mockito.times(1)).run(result);
    }

    @Test
    public void testSetUp() {
        test.setUp();
        test.testMethod();
        assertTrue(test.log.equals("setUp testMethod "));
    }

    @Test
    public void testTemplateMethod() {
        test.testMethod();
        TestResult result = new TestResult();
        test.run(result);
        assertTrue(test.log.equals("setUp testMethod tearDown "));
    }

    @Test
    public void testResult() {
        //given
        TestResult result = new TestResult();
        //when
        test.testMethod();
        result = test.run(result);
        //then
        assertTrue("1 run, 0 failed".equals(result.summary()));
    }

    @Test
    public void testFailedResult() throws Exception {
        TestResult result = new TestResult();
        TestCase testCase = new TestCase("testBrokenMethod");
        result = testCase.run(result);
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    @Test
    public void testFailedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    @Test
    public void testSuite(){
        TestSuite suite = new TestSuite();
        suite.add(new TestCase("testTemplateMethod"));
        suite.add(new TestCase("testBrokenMethod"));
        TestResult result = new TestResult();
        suite.run(result);
        assertEquals("2 run, 1 failed", result.summary());
    }
}
