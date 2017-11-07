package com.tabor.pythonPart;

/**
 * Created by marek on 06.11.2017.
 */
public class TestCase {

    boolean wasRun;
    String log;

    TestResult run(){
        TestResult result = new TestResult();
        result.testStarted();
        setUp();
        testMethod();
        tearDown();
        this.wasRun = Boolean.TRUE;
        return result;
    }

    boolean setUp() {
        this.log = "setUp ";
        return Boolean.TRUE;
    }

    void testMethod(){
        this.wasRun = Boolean.TRUE;
        this.log = log + "testMethod ";
    }

    void tearDown(){
        this.log = log + "tearDown ";
    }

    void testBrokenMethod() throws Exception {
        throw new Exception();
    }
}
