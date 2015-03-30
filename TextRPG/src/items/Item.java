package items;

import java.util.ArrayList;
import java.util.Arrays;

import rpgObjectClasses.Entity;
import mapInternals.Room;

public abstract class Item extends Entity
{
	protected boolean carried;
	protected ArrayList<String> itemUses = new ArrayList<String>(Arrays.asList("Examine", "Drop"));
	
	protected void ExamineAction()
	{
		FL.PrintL(""); // add to this
	}
	
	
	public Item(Room startingLocation, String name)
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
	
	public ArrayList<String> getItemUses()
	{
		return itemUses;
	}
	
	public void executeAction(int option)
	{
		switch (option)
		{
		case 0:
			
		
		}
	}
	
	static public void move(Item theThing, ItemCarrier source, ItemCarrier destination) // Moves item from source into the destination
	{
		source.removeItem(theThing);
		destination.addItem(theThing);
	}	
}
