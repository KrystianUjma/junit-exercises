package com.practicalunittesting.chp06.timeprovider;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
@RunWith(JUnitParamsRunner.class)
public class HelloRedesignedTest {

	private HelloRedesigned hello;
	private TimeProvider timeProvider;

	@Before
	public void setUp() {
		timeProvider = mock(TimeProvider.class);
		hello = new HelloRedesigned(timeProvider);
	}

	@Test
	public void shouldSayGoodMorningInTheMorning() {
    when(timeProvider.isMorning()).thenReturn(true);
		assertEquals("Good Morning!", hello.sayHello());
	}

	@Test
	public void shouldSayGoodAfternoonInTheAfternoon() {
    when(timeProvider.isMorning()).thenReturn(false);
		assertEquals("Good Afternoon!", hello.sayHello());
	}

}

