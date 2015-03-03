package rpgObjectClasses;

import mapInternals.Room;

/*
 * The class that hopefully will be able to represent all items and characters
 */
public abstract class Entity {
	private Room location;
	private String name;
	/* Maybe add more stuff? */
	
	Entity (Room location, String name)
	{
		this.location = location;
		this.name = name;
	}
	
	public Room WhereBeThis()
	{
		return location;
	}

	public void MoveTo(Room locationNew)
	{
		location = locationNew;
	}
	
	public String Name()
	{
		return this.name;
	}
}
