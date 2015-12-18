package com.practicalunittesting.chp06.timeprovider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TimeProviderTest {

  private TimeProvider timeProvider;

  private static final Integer[] morningHours() {
    return new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
  }

  @Test
  @Parameters(method = "morningHours")
  public void shouldSayGoodMorningInTheMorning(int morningHour) {
    timeProvider = new TimeProviderImpl(getCalendar(morningHour));

    assertTrue(timeProvider.isMorning());
  }

  private static final Object[] afternoonHours() {
    return new Integer[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
  }


  @Test
  @Parameters(method = "afternoonHours")
  public void shouldSayGoodAfternoonInTheAfternoon(int afternoonHour) {
    timeProvider = new TimeProviderImpl(getCalendar(afternoonHour));

    assertFalse(timeProvider.isMorning());
  }

  @Test
  public void shouldReturnTime(){
    Calendar calendar = getCalendar(10);
    timeProvider = new TimeProviderImpl(calendar);

    assertNotNull(timeProvider.getTime());
    assertEquals(calendar.getTime(), timeProvider.getTime().getTime());
  }


  private Calendar getCalendar(int hour) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, hour);
    return cal;
  }
}
