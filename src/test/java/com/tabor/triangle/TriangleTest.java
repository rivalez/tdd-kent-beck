package com.tabor.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testEquilateral(){
        //given
        Triangle triangle = new Triangle(1,1,1);

        //then
        Assert.assertTrue(triangle.isEquilateral());
    }

    @Test
    public void testIsosceles(){
        //given
        Triangle triangle = new Triangle(1,1,2);

        //then
        Assert.assertTrue(triangle.isIsosceles());
    }

    @Test
    public void testScalene(){
        //given
        Triangle triangle = new Triangle(3,2,4);
        //then
        Assert.assertTrue(triangle.isScalene());
    }

    @Test(expected = Exception.class)
    public void testTriangle0sides(){
        //given
        new Triangle(0,0,0);
    }

    @Test(expected = Exception.class)
    public void testTriangleValuesLessThanZero(){
        //given
        new Triangle(-20, 2, 3);
    }
}
