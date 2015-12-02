package com.guilhermef.NasaRobot;

import junit.framework.TestCase;
import com.guilhermef.NasaRobot.Robonaut;

public class RobonautTest extends TestCase {

	private Robonaut robot;

	protected void setUp() throws Exception {
		this.robot = new Robonaut();
	}

	public void testGetFinalPositionWhenStopped() {
		String pos = this.robot.getFinalPosition();
		assertEquals("(0, 0, N)", pos);
	}
	
	public void testOnInvalidParams() {
		boolean passed = false;
		try{
			this.robot.move("AAA");
		} catch (IllegalArgumentException e) {
			passed = true;
		} catch (OutOfBoundaries e) {
			e.printStackTrace();
		}
		assertTrue(passed);
	}
	
	public void testOnRunningToTheHills() {
		boolean passed = false;
		try{
			this.robot.move("MMMMMMMMMMMMMMMMMMMMMMMM");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (OutOfBoundaries e) {
			passed = true;
		}
		assertTrue(passed);
	}
	
	public void testOnHittingNotSoHardTheDanceFloor() throws IllegalArgumentException, OutOfBoundaries {
		this.robot.move("MML");
		String pos = this.robot.getFinalPosition();
		assertEquals("(0, 2, W)", pos);
	}
	
	public void testOnHittingHardTheDanceFloor() throws IllegalArgumentException, OutOfBoundaries {
		this.robot.move("MMRMMRMM");
		String pos = this.robot.getFinalPosition();
		assertEquals("(2, 0, S)", pos);
	}

}
