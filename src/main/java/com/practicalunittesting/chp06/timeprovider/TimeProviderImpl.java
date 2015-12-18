package com.practicalunittesting.chp06.timeprovider;

import java.util.Calendar;

public class TimeProviderImpl implements TimeProvider{

  private Calendar calendar;

  public TimeProviderImpl(Calendar calendar) {
    this.calendar = calendar;
  }

  @Override
  public Calendar getTime() {
    return calendar;
  }

  @Override
  public boolean isMorning() {
    if (calendar.get(Calendar.HOUR_OF_DAY) < 12) {
      return true;
    }
    return false;
  }
}
