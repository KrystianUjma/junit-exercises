package com.practicalunittesting.chp06.time;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class HelpDeskRedesignedTest {

  private HelpDeskRedesigned helpDesk;
  private TimeProvider timeProvider;
  private Issue issue = mock(Issue.class);

  @Before
  public void setUp(){
    timeProvider = mock(TimeProvider.class);
    helpDesk = new HelpDeskRedesigned(timeProvider);
  }

  private static final Integer[] workDays() {
    return new Integer[]{Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY};
  }

  @Test
  @Parameters(method = "workDays")
  public void shouldHandleIssueOnWorkDay(Integer day){
    Calendar cal = getCalendar(day);

    when(timeProvider.getTime()).thenReturn(getCalendar(day));

    boolean willHandleIssue = helpDesk.willHandleIssue(issue);

    assertTrue(willHandleIssue);
  }


  private static final Integer[] freeDays() {
    return new Integer[]{Calendar.SATURDAY, Calendar.SUNDAY};
  }

  @Test
  @Parameters(method = "freeDays")
  public void shouldNotHandleIssueOnFreeDay(Integer day){
    when(timeProvider.getTime()).thenReturn(getCalendar(day));

    boolean willHandleIssue = helpDesk.willHandleIssue(issue);

    assertFalse(willHandleIssue);
  }

  @Test
  public void shouldNotHandleIssueOnFridayAfter17(){
    Calendar cal = getCalendar(Calendar.FRIDAY);
    cal.set(Calendar.HOUR_OF_DAY, 18);

    when(timeProvider.getTime()).thenReturn(cal);

    boolean willHandleIssue = helpDesk.willHandleIssue(issue);

    assertFalse(willHandleIssue);
  }


  private Calendar getCalendar(int day) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DAY_OF_WEEK, day);
    return cal;
  }
}
