package mapInternals;

import java.util.ArrayList;

import main.FL;
import rpgObjectClasses.*;
import items.Item;
import items.ItemCarrier;

public class Room implements ItemCarrier {
	private String 
		name,
		desc;
	private int brightness;
	private ArrayList<Door> exitDoors = new ArrayList<Door>();
	private ArrayList<Item> items = new ArrayList<Item>();
	
	private ArrayList<String> playerChoices = new ArrayList<String>();
	
	Room()
	{
		name = "";
		desc = "";
		SetBrightness(3);
	}
	
	Room(String title, String description)
	{
		name = title;
		desc = description;
		SetBrightness(3);
	}
	
	Room(String title, String description, int lightLevel)
	{
		name = title;
		desc = description;
		SetBrightness(lightLevel);
		/*		
		for (Door exit : doors)
			exitDoors.add(exit);
		*/
	}
	
	// Getters and Setters //
	
	public ArrayList<Door> GetAllDoors()
	{
		return exitDoors;
	}

	public String GetName() {
		return name;
	}

	public void SetName(String title) {
		name = title;
	}

	public String GetDescription() {
		return desc;
	}

	public void SetDescription(String descriptionNew) {
		desc = descriptionNew;
	}

	public int GetBrightness() {
		return brightness;
	}

	public void SetBrightness(int brightnessNew) {
		brightness = brightnessNew;
	}
	// Getters and Setters (end) //
	
	// Item Functions //
	public void addItem(Item theThing)
	{
		items.add(theThing);
	}
	public void removeItem(Item theThing)
	{
		items.remove(theThing);
	}
	public boolean hasItem(Item theThing)
	{
		for (Item item : items) {
			if (item.equals(theThing))
				return true;
		}
		return false;
	}
	
	public void Enter(Actor p)
	{
		FL.PrintL(p.Name() + " has entered the " + this.name + ": " + this.desc);
	}
	
	public void PlayerInput(HumanPlayer p)
	{
		String choice = FL.InputString("What would you like to do?", playerChoices);
		
		
		
	}
}
