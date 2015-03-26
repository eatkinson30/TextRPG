package mapInternals;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	private static final ArrayList<String> playerChoices = new ArrayList<String>(Arrays.asList("Move", "Search", "Inventory"));
	private static final int 
		MOVE = 0,
		ITEM = 1,
		FIGHT = 2,
		OTHER = 3;
	
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
	
	
	// The function that handles each turn's actions //
	public void PlayerTurn(HumanPlayer p)
	{
		int i;
		int choice = FL.InputInt("What would you like to do? " + FL.StringifyArrayWithNumbers(playerChoices)  + "\n>> ", 1, playerChoices.size());
		
		--choice; // changes 1 based to 0 based indexing
		
		FL.PrintL("You chose to " + playerChoices.get(choice));
		
		boolean keepGoing = false;
		switch(choice)
		{
		case MOVE:
			do
			{
				keepGoing = PlayerMove(p);
			} while (keepGoing);
			
			break;
		case ITEM:
			do
			{
				keepGoing = PlayerItem(p);
			} while (keepGoing);
			break;
		case FIGHT:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	public boolean PlayerMove(HumanPlayer p)
	{
		ArrayList<String> optionMsgs = new ArrayList<>();
		for (int i = 0; i < exitDoors.size(); ++i)
		{
			String otherRoom = exitDoors.get(i).GetOtherRoom(this).GetName();
			String otherDirection = FL.StringDirection(exitDoors.get(i).GetOtherDirection(this));
			optionMsgs.add(otherDirection + " to " + otherRoom);
		}
		
		int choice = FL.InputInt("Where would you like to move? " + FL.StringifyArrayWithNumbers(optionMsgs)  + "\n>> ", 0, optionMsgs.size());
		--choice; // changes 1 based to 0 based indexing
		
		if (choice < 0) // User chooses to go back to previous menu
			return false;
		
		p.MoveTo(exitDoors.get(choice).GetOtherRoom(this));
		return false;
	}
	
	public boolean PlayerItem(HumanPlayer p)
	{
		ArrayList<String> optionMsgs = new ArrayList<>();
		for (int i = 0; i < exitDoors.size(); ++i)
		{
			String otherRoom = exitDoors.get(i).GetOtherRoom(this).GetName();
			String otherDirection = FL.StringDirection(exitDoors.get(i).GetOtherDirection(this));
			optionMsgs.add(otherDirection + " to " + otherRoom);
		}
		
		int choice = FL.InputInt("Where would you like to move? " + FL.StringifyArrayWithNumbers(optionMsgs)  + "\n>> ", 0, optionMsgs.size());
		--choice; // changes 1 based to 0 based indexing
		
		if (choice < 0) // User chooses to go back to previous menu
			return false;
		
		return false;
	}
}
