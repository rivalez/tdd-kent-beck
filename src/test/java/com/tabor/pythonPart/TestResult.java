package com.tabor.pythonPart;

public class TestResult {

    private int runCount;
    private int errorCount;

    TestResult() {
        this.runCount = 0;
        this.errorCount = 0;
    }

    void testStarted() {
        this.runCount++;
    }

    void testFailed() {
        this.errorCount++;
    }

    String summary() {
        return String.format("%d run, %d failed", this.runCount, this.errorCount);
    }
}
