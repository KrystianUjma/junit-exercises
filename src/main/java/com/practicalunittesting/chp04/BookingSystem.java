package com.practicalunittesting.chp04;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Veezq on 2015-10-31.
 */
public class BookingSystem {

    private final int UPPER_BOUND_LEGALL_HOUR = 23;
    private final int LOWER_BOUND_LEGALL_HOUR = 0;


    private Map<Integer, Boolean> bookedHours = new HashMap<>();

    public boolean isAlreadyBooked(int bookedHour) {

        return bookedHours.get(bookedHour) == null ? false : true;
    }

    public void addBooking(int i) {
        if(!isHourLegal(i)) {
            throw new IllegalArgumentException("Choose only legal hours");
        }
        if(isAlreadyBooked(i)){
            throw new IllegalStateException("hour is already booked");
        }

        bookedHours.put(i, true);
    }

    public boolean isHourLegal(int i){
        if(i > UPPER_BOUND_LEGALL_HOUR || i < LOWER_BOUND_LEGALL_HOUR) {
            return false;
        }
        return true;
    }
}
