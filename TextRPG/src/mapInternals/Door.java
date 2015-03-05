package mapInternals;

import main.FL;

public class Door {
	private Room room1, room2;
	private FL.Direction directionOnetoTwo, directionTwoToOne;

	Door(Room room1, Room room2, FL.Direction directionOnetoTwo, FL.Direction directionTwoToOne) {
		this.room1 = room1;
		this.room2 = room2;
		this.directionOnetoTwo = directionOnetoTwo;
		this.directionTwoToOne = directionTwoToOne;
	}
	
	public FL.Direction GetDirectionFromRoom1() {
		return this.directionOnetoTwo;
	}
	
	public FL.Direction GetDirectionFromRoom2() {
		return FL.FlipDirection(this.directionTwoToOne);
	}
}
