package mapInternals;

import main.FL;
import main.FL.Direction;

public class LockedDoor extends Door {

	public LockedDoor(Room room1, Room room2, Direction directionOnetoTwo, FL.Color color) {
		super(room1, room2, directionOnetoTwo);
		// TODO Auto-generated constructor stub
	}

	public LockedDoor(Room room1, Room room2, Direction directionOnetoTwo,
			Direction directionTwoToOne) {
		super(room1, room2, directionOnetoTwo, directionTwoToOne);
		// TODO Auto-generated constructor stub
	}

}
