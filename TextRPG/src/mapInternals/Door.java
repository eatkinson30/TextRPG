package mapInternals;

import rpgObjectClasses.Actor;
import main.FL;

public class Door {
	protected Room room1, room2;
	protected FL.Direction directionOnetoTwo;
	protected FL.Direction directionTwoToOne;	

	public Door(Room room1, Room room2, FL.Direction directionOnetoTwo) {
		this.SetRoom1(room1);
		this.SetRoom2(room2);
		this.directionOnetoTwo = directionOnetoTwo;
		this.directionTwoToOne = FL.FlipDirection(directionOnetoTwo);
	}	
	
	public Door(Room room1, Room room2, FL.Direction directionOnetoTwo, FL.Direction directionTwoToOne) {
		this.SetRoom1(room1);
		this.SetRoom2(room2);
		this.directionOnetoTwo = directionOnetoTwo;
		this.directionTwoToOne = directionTwoToOne;
	}
	
	public FL.Direction GetDirectionFromRoom1() {
		return this.directionOnetoTwo;
	}
	
	public FL.Direction GetDirectionFromRoom2() {
		return FL.FlipDirection(this.directionTwoToOne);
	}

	public Room GetRoom1() {
		return room1;
	}

	public void SetRoom1(Room room1) {
		this.room1 = room1;
	}

	public Room GetRoom2() {
		return room2;
	}

	public void SetRoom2(Room room2) {
		this.room2 = room2;
	}
	
	public Room GetOtherRoom(Room test)
	{
		if (test.equals(room1))
			return room2;
		else if (test.equals(room2))
			return room1;
		else
			// Complain //
			return null;
	}
	
	public FL.Direction GetOtherDirection(Room test)
	{
		if (test.equals(room1))
			return directionOnetoTwo;
		else if (test.equals(room2))
			return directionTwoToOne;
		else
			// Complain //
			return null;
	}
	
	public boolean IsPassableFor(Actor character)
	{
		return false;		
	}
}
