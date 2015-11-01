package com.practicalunittesting.chp04;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Veezq on 2015-10-30.
 */
@RunWith(JUnitParamsRunner.class)
public class RegexTest {


    public static String[][] getPasswords(){
        return new String[][]{
                {"cdefg 345 12bb23", "345"},
                {"abc 123", "123"},
                {"abc 1234", "1234"},
                {"cdefg 345 12bbb33 678tt", "345, 678"},


        };
    }

    @Test
    @Parameters(method = "getPasswords")
    public void constructorShouldSetPassword(String password, String output){
        Regex regex = new Regex(password);

        List<Integer> expectedOutput = Stream.of(output.split(", "))
                                        .map(string -> Integer.parseInt(string))
                                        .collect(Collectors.toList());

        assertEquals(expectedOutput, regex.resolve());
    }


    @Test
    public void constructorShouldReturnEmptyList(){
        Regex regex = new Regex("abc 12");

        assertEquals(Collections.emptyList(), regex.resolve());
    }




}