package com.guilhermef.NasaRobot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobonautTest {

	private Robonaut robot;

	@Before
	public void setUp() throws Exception {
		this.robot = new Robonaut();
	}

	@Test
	public void testGetFinalPositionWhenStopped() {
		String pos = this.robot.getFinalPosition();
		Assert.assertEquals("(0, 0, N)", pos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOnInvalidParams() throws IllegalArgumentException, OutOfBoundaries {
		this.robot.move("AAA");
	}
	
	@Test(expected = OutOfBoundaries.class)
	public void testOnRunningToTheHills() throws IllegalArgumentException, OutOfBoundaries {
		this.robot.move("MMMMMMMMMMMMMMMMMMMMMMMM");
	}
	
	@Test
	public void testOnHittingNotSoHardTheDanceFloor() throws IllegalArgumentException, OutOfBoundaries {
		this.robot.move("MML");
		String pos = this.robot.getFinalPosition();
		Assert.assertEquals("(0, 2, W)", pos);
	}
	
	@Test
	public void testOnHittingHardTheDanceFloor() throws IllegalArgumentException, OutOfBoundaries {
		this.robot.move("MMRMMRMM");
		String pos = this.robot.getFinalPosition();
		Assert.assertEquals("(2, 0, S)", pos);
	}

}
