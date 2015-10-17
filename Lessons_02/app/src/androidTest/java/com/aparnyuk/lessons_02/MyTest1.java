package com.aparnyuk.lessons_02;

import junit.framework.TestCase;

import java.math.BigInteger;

/**
 * Created by Anna on 17.10.2015.
 */

public class MyTest1 extends TestCase {
    public void testFunc() throws Exception{
       // Test myFactorial function
        assertEquals(BigInteger.ONE, ActivityTwo.myFactorial(0));
        assertEquals(BigInteger.valueOf(6), ActivityTwo.myFactorial(3));
        assertEquals(BigInteger.valueOf(120) ,ActivityTwo.myFactorial(5));

        // Test myFibonacci function
        assertEquals( BigInteger.ZERO,ActivityTwo.myFibonacci(0));
        assertEquals(BigInteger.ONE ,ActivityTwo.myFibonacci(1));
        assertEquals(BigInteger.ONE ,ActivityTwo.myFibonacci(2));
        assertEquals(BigInteger.valueOf(8) ,ActivityTwo.myFibonacci(6));
    }
}