package com.practicalunittesting.chp04;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Veezq on 2015-10-31.
 */

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {


    private final Integer ZERO_HOUR = 0;
    private final Integer FIRST_HOUR = 1;
    private final Integer SECOND_HOUR = 2;
    private BookingSystem bookingSystem;

    @Before
    public void setUp(){
        bookingSystem = new BookingSystem();
    }

    @Test
    public void shouldGetEmptyList(){

        assertEquals(false, bookingSystem.isAlreadyBooked(ZERO_HOUR));
    }

    @Test
    public void shouldGetNonEmptyList(){
        bookingSystem.addBooking(FIRST_HOUR);

        assertNotEquals("Booked 1 hour, but list contains " + bookingSystem.isAlreadyBooked(FIRST_HOUR) + " elements",
                ZERO_HOUR, bookingSystem.isAlreadyBooked(FIRST_HOUR));
    }

    public static Integer[] getIllegalNumbers(){
        return new Integer[]{ 24, -1 };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getIllegalNumbers")
    public void shouldNotLetCreateForMoreThanUpperBoundHours(int number){
        bookingSystem.addBooking(number);

    }

    @Test
    public void shouldReturnTwoBookedHoursForTwoBookings(){
        bookingSystem.addBooking(FIRST_HOUR);
        bookingSystem.addBooking(SECOND_HOUR);

        assertTrue(bookingSystem.isAlreadyBooked(FIRST_HOUR));
        assertTrue(bookingSystem.isAlreadyBooked(SECOND_HOUR));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotLetBookOnAlreadyBookedHours(){
        bookingSystem.addBooking(FIRST_HOUR);
        bookingSystem.addBooking(FIRST_HOUR);
    }





}