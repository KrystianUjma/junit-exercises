package com.practicalunittesting.chp6exercises;

/**
 * Created by Veezq on 2015-12-16.
 */
public class StateTesting {
    public String reverse(String s) {
        if(s == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
           sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
