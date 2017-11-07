package com.tabor.pythonPart;

import java.util.ArrayList;
import java.util.List;

class TestSuite {

    List<TestCase> tests;

    TestSuite(){
        tests = new ArrayList<>();
    }

    void add(TestCase testCase){
        tests.add(testCase);
    }

    void run(TestResult result){
        for(TestCase testCase : tests){
            testCase.run(result);
        }
    }

}
