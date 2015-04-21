package mapInternals;

import items.Keycard;
import rpgObjectClasses.Actor;
import main.FL;
import main.FL.Direction;

public class LockedDoor extends Door {
	private FL.Color color;
	private Keycard key;
	
	// Constructors //
	public LockedDoor(Room room1, Room room2, Direction directionOnetoTwo, FL.Color color) {
		super(room1, room2, directionOnetoTwo);
		this.setColor(color);
	}

	public LockedDoor(Room room1, Room room2, Direction directionOnetoTwo,
			Direction directionTwoToOne, FL.Color color) {
		super(room1, room2, directionOnetoTwo, directionTwoToOne);
		this.setColor(color);
	}
	// // //
	
	// Getters and Setters //
	public FL.Color getColor() {
		return color;
	}

	public void setColor(FL.Color color) {
		this.color = color;
	}
	// // //
	
	public boolean IsPassableFor(Actor character)
	{
		return character.GetItems().contains(key);
	}
}
