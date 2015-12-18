package com.practicalunittesting.chp06.timeprovider;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public class HelloRedesigned {

	private TimeProvider timeProvider;

	public HelloRedesigned(TimeProvider timeProvider) {
			this.timeProvider = timeProvider;
	}

	public String sayHello() {
    if(timeProvider.isMorning()){
      return "Good Morning!";
    }else {
			return "Good Afternoon!";
		}
	}
}

