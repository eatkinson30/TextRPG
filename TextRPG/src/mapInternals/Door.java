package mapInternals;

import main.FL;

public class Door {
	private Room room1, room2;
	private FL.Direction direction;

	Door(Room room1, Room room2, FL.Direction direction) {
		this.room1 = room1;
		this.room2 = room2;
		this.direction = direction;
	}
	
	public FL.Direction GetDirectionFromRoom1() {
		return this.direction;
	}
}
