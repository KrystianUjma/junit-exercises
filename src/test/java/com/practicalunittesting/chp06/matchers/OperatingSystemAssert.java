package com.practicalunittesting.chp06.matchers;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class OperatingSystemAssert extends GenericAssert<OperatingSystemAssert, OperatingSystem> {

  protected OperatingSystemAssert(OperatingSystem actual) {
    super(OperatingSystemAssert.class, actual);
  }

  public static OperatingSystemAssert assertThat(OperatingSystem actual){
    return new OperatingSystemAssert(actual);
  }

  public OperatingSystemAssert is128bit() {
    isNotNull();
    String errorMessage = String.format("Expected operatingSystem's number of bits to be <%s> but was <%s>",128, actual.getNbOfBits());

    Assertions.assertThat(actual.getNbOfBits())
            .overridingErrorMessage(errorMessage)
            .isEqualTo(128);
    return this;
  }

  public OperatingSystemAssert wasReleasedIn(int i) {
    isNotNull();
    String errorMessage = String.format("Expected operatingSystem's release year to be <%s> but was <%s>",128, actual.getReleaseYear());

    Assertions.assertThat(actual.getReleaseYear())
            .overridingErrorMessage(errorMessage)
            .isEqualTo(i);
    return this;
  }

  public OperatingSystemAssert hasVersion(String version) {
    isNotNull();
    String errorMessage = String.format("Expected operatingSystem's version to be <%s> but was <%s>",128, actual.getVersion());

    Assertions.assertThat(actual.getVersion())
            .overridingErrorMessage(errorMessage)
            .isEqualTo(version);
    return this;
  }
}
