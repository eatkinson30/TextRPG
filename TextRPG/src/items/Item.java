package items;

import java.util.ArrayList;
import java.util.Arrays;

import rpgObjectClasses.Actor;
import rpgObjectClasses.Entity;
import main.FL;
import mapInternals.Room;

public abstract class Item extends Entity
{
	protected boolean carried;
	protected ArrayList<String> itemUses = new ArrayList<String>(Arrays.asList("Examine", "Drop"));
	
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
	
	public void executeAction(int option) // Chooses which method to call based on a number representing a choice made by the player to perform a certain action on the item
	{
		switch (option)
		{
		default:
		}
	}
	
	// Action handlers //
	protected void ExamineAction() // Description for item // override this in subclasses
	{
		FL.PrintL("");
	}
	
	protected void DropAction(Actor character) // Removes item from inventory to the enclosing Room
	{
			move(character, character.WhereBeThis());
	}
	// // //
	
	public void move(ItemCarrier source, ItemCarrier destination) // Moves item from source into the destination
	{
		source.removeItem(this);
		destination.addItem(this);
	}	
}
