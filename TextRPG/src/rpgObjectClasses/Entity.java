package rpgObjectClasses;

import mapInternals.Room;

/*
 * The class that hopefully will be able to represent all items and characters
 */
public abstract class Entity {
	protected Room location;
	protected String name;
	/* Maybe add more stuff? */
	
	public Entity (Room location, String name)
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
		location.Enter();
	}
	
	public String Name()
	{
		return this.name;
	}
}
