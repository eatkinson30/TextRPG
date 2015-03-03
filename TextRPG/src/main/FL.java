package main;


public final class FL {
	public static enum Direction {
		NORTH,
		SOUTH,
		WEST,
		EAST,
		LOST
	}
	
	public static Direction 180Deg(Direction start) {
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
}
