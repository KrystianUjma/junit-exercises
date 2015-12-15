package com.practicalunittesting.chp6exercises;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Veezq on 2015-12-16.
 */
@RunWith(JUnitParamsRunner.class)
public class StateTestingTest {

    private StateTesting stateTesting = new StateTesting();


    @Test
    public void shouldReturnEmptyString(){

        //act
        String reversed = stateTesting.reverse("");

        //assert
        assertEquals("", reversed);
    }

    @Test
    public void shouldReturnNull(){

        //act
        String reversed = stateTesting.reverse(null);

        //assert
        assertNull(reversed);
    }

    public static String[][] getStringsToReverse(){
        return new String[][]{
            { "abcdefg", "gfedcba" },
            { "qwerty", "ytrewq" },
            { "!@#$%^&", "&^%$#@!" }};
    }

    @Test
    @Parameters(method = "getStringsToReverse")
    public void shouldReverse(String toReverse, String expected){

        //act
        String reversed = stateTesting.reverse(toReverse);

        //assert
        assertEquals(expected, reversed);
    }

}