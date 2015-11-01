package com.practicalunittesting.chp04;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Veezq on 2015-10-30.
 */
public class Regex {

    private String password;

    public Regex(String password) {
        this.password = password;
    }

    public List<Integer> resolve() {
        List<Integer> list = new ArrayList<>();

        Matcher matcher = getMatcher();

        while(matcher.find()){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
//            System.out.println(password.substring(startIndex,endIndex));
            String foundMatching = password.substring(startIndex, endIndex);
            list.add(Integer.parseInt(foundMatching));
        }

        return list;
    }

    private Matcher getMatcher(){
        String patternString = "[0-9]{3,}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(password);

        return matcher;
    }

}
