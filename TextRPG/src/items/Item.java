package items;

import rpgObjectClasses.Entity;
import mapInternals.Room;

public abstract class Item extends Entity
{
	private boolean carried;
	
	Item(Room startingLocation, String name)
	{
		super(startingLocation, name);
		
		carried = false;
	}

	public void pickedUp()
	{
		carried = true;
	}
	
	public void dropped()
	{
		carried = false;
	}
	
	public boolean isCarried()
	{
		return carried;
	}
}
