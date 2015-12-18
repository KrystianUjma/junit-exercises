package com.practicalunittesting.chp06.matchers;

import org.junit.Test;

public class OperatingSystemTest {

  private OperatingSystem os;

  @Test
  public void testUsingMatcher(){
    os = new OperatingSystem();
    os.setNbOfBits(128);
    os.setReleaseYear(2013);
    os.setVersion("9");

    OperatingSystemAssert.assertThat(os).is128bit().wasReleasedIn(2013).hasVersion("9");

  }
}
