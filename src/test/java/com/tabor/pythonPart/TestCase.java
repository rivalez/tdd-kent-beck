package com.tabor.pythonPart;

import static com.tabor.pythonPart.PythonTest.TEST_BROKEN_METHOD;

/**
 * Created by marek on 06.11.2017.
 */
class TestCase {

    boolean wasRun;
    private String name;
    String log;

    TestCase() {
        this.name = "";
    }

    TestCase(String methodName) {
        this.name = methodName;
    }

    TestResult run(TestResult result) {
        result.testStarted();
        setUp();
        try {
            if (name.equals(TEST_BROKEN_METHOD)) {
                testBrokenMethod();
            } else {
                testMethod();
            }
        } catch (Exception e) {
            result.testFailed();
        }
        tearDown();
        this.wasRun = Boolean.TRUE;
        return result;
    }

    boolean setUp() {
        this.log = "setUp ";
        return Boolean.TRUE;
    }

    void testMethod() {
        this.wasRun = Boolean.TRUE;
        this.log = log + "testMethod ";
    }

    void tearDown() {
        this.log = log + "tearDown ";
    }

    void testBrokenMethod() throws Exception {
        throw new Exception();
    }
}
