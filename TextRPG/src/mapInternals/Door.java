package mapInternals;

import main.FLOld;

public class Door {
	private Room room1, room2;
	private FLOld.Direction directionOnetoTwo, directionTwoToOne;

	Door(Room room1, Room room2, FLOld.Direction directionOnetoTwo, FLOld.Direction directionTwoToOne) {
		this.room1 = room1;
		this.room2 = room2;
		this.directionOnetoTwo = directionOnetoTwo;
		this.directionTwoToOne = directionTwoToOne;
	}
	
	public FLOld.Direction GetDirectionFromRoom1() {
		return this.directionOnetoTwo;
	}
	
	public FLOld.Direction GetDirectionFromRoom2() {
		return FLOld.FlipDirection(this.directionTwoToOne);
	}
}
