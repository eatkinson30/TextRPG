package main;

import java.util.Scanner;


public final class FL {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static enum Direction {
		NORTH,
		SOUTH,
		WEST,
		EAST,
		LOST
	}
	
	public static Direction FlipDirection(Direction start) {
		switch (start) {
		case NORTH:
			return Direction.SOUTH;
		case SOUTH:
			return Direction.NORTH;
		case EAST:
			return Direction.WEST;
		case WEST:
			return Direction.EAST;
		default:
			return Direction.LOST;
		}
	}
	
	public static Direction RotateDirection(Direction start, boolean clockwise) {
		switch (start) {
		case NORTH:
			return clockwise ? Direction.EAST : Direction.WEST;
		case SOUTH:
			return clockwise ? Direction.WEST : Direction.EAST;
		case EAST:
			return clockwise ? Direction.SOUTH : Direction.NORTH;
		case WEST:
			return clockwise ? Direction.NORTH : Direction.SOUTH;
		default:
			return Direction.LOST;
		}
	}
	
	public static void Print(Object obj) {
		System.out.print(obj.toString());
	}
	
	public static void PrintLn(Object obj) {
		System.out.println(obj.toString());
	}
}
