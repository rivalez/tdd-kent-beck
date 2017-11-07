package com.tabor.pythonPart;

import com.sun.security.ntlm.Server;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.Socket;
import java.nio.Buffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static sun.net.ftp.FtpClient.defaultPort;

/**
 * Created by marek on 06.11.2017.
 */
public class PythonTest {

    public static final String TEST_BROKEN_METHOD = "testBrokenMethod";
    public static final String TEST_TEMPLATE_METHOD = "testTemplateMethod";
    public static final String TEST_FAILED_RESULT_FORMATTING = "testFailedResultFormatting";
    public static final String TEST_FAILED_RESULT = "testFailedResult";
    public static final String TEST_SUITE = "testSuite";
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
        //given
        TestResult result = new TestResult();
        //when
        test.testMethod();
        test.run(result);
        //then
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
        TestCase testCase = new TestCase(TEST_BROKEN_METHOD);
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
        suite.add(new TestCase(TEST_TEMPLATE_METHOD));
        suite.add(new TestCase(TEST_BROKEN_METHOD));
        suite.add(new TestCase(TEST_FAILED_RESULT_FORMATTING));
        suite.add(new TestCase(TEST_FAILED_RESULT));
        suite.add(new TestCase(TEST_SUITE));
        TestResult result = new TestResult();
        suite.run(result);
        assertEquals("5 run, 1 failed", result.summary());
    }
}
