package com.tabor.pythonPart;

/**
 * Created by marek on 06.11.2017.
 */
public class WasRun {

    boolean wasRun;
    String log;

    boolean run(){
        setUp();
        testMethod();
        tearDown();
        return this.wasRun = Boolean.TRUE;
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

}
