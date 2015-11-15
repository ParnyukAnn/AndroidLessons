package com.aparnyuk.lessons_02;

import junit.framework.TestCase;

import java.math.BigInteger;

/**
 * Created by Anna on 17.10.2015.
 */

public class MyTest1 extends TestCase {
    public void testFunc() throws Exception{
       // Test myFactorial function
        assertEquals(BigInteger.ONE, FragmentLesson2.myFactorial(0));
        assertEquals(BigInteger.valueOf(6), FragmentLesson2.myFactorial(3));
        assertEquals(BigInteger.valueOf(120) , FragmentLesson2.myFactorial(5));

        // Test myFibonacci function
        assertEquals( BigInteger.ZERO, FragmentLesson2.myFibonacci(0));
        assertEquals(BigInteger.ONE , FragmentLesson2.myFibonacci(1));
        assertEquals(BigInteger.ONE , FragmentLesson2.myFibonacci(2));
        assertEquals(BigInteger.valueOf(8) , FragmentLesson2.myFibonacci(6));
    }
}