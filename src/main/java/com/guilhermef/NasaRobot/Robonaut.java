package com.guilhermef.NasaRobot;


public class Robonaut {
	private int x = 0;
	private int y = 0;
	private int direction = 0;
	static private String[] namedDirection = {"N", "E", "S", "W"};
	private String ArgumentPattern = "[MRL]+";
	
	public String getFinalPosition() {
		String finalPosition = "(" + this.x + ", " + this.y + ", " + this.getNamedDirection() + ")"; 
		return finalPosition;
	}

	public void move(String danceMoves) throws IllegalArgumentException, OutOfBoundaries {
		if (!danceMoves.matches(ArgumentPattern)){
			throw new IllegalArgumentException();
		};
		for (int i = 0; i < danceMoves.length(); i++) {
			this.doTheDance(danceMoves.charAt(i));
			if (this.x > 4 || this.x < 0 || this.y > 4 || this.y < 0) {
				throw new OutOfBoundaries();
			}
		}
	}
	
	private void doTheDance(char move) {
		switch (move) {
		case 'L':
			this.turn(-1);
			break;
		case 'R':
			this.turn(1);
			break;
		default:
			this.moveForward();
			break;
		}
		
	}

	
	private void moveForward() {
		switch (this.direction) {
		case 0:
			this.y++;
			break;
		case 1:
			this.x++;
			break;
		case 2:
			this.y--;
			break;
		case 3:
			this.x--;
			break;
		default:
			break;
		}
	}

	private void turn(int i) {
		this.direction = this.direction + i;
		if (this.direction < 0) {
			this.direction = 3;
		} else if (this.direction > 3) {
			this.direction = 0;
		}
	}

	private String getNamedDirection() {
		return namedDirection[this.direction];
	}
}
