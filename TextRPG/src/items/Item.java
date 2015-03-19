package items;

import rpgObjectClasses.Entity;
import mapInternals.Room;

public abstract class Item extends Entity
{
	protected boolean carried;
	
	Item(Room startingLocation, String name)
	{
		super(name);
		
		
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
	
	static public void move(Item theThing, ItemCarrier source, ItemCarrier destination) // Moves item from source into the destination
	{
		source.removeItem(theThing);
		destination.addItem(theThing);
	}
}
