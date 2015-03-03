package rpgObjectClasses;

import mapInternals.Room;

/*
 * The class that hopefully will be able to represent all items and characters
 */
public class Entity {
	private Room location;
	/* Maybe add more stuff? */
	
	Entity (Room startingLocation)
	{
		location = startingLocation;
	}
	
	public Room whereBeThis()
	{
		return location;
	}

	public void IsNowAt(Room locationNew)
	{
		location = locationNew;
	}
}
