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
	
	private static final ArrayList<String> playerChoices = new ArrayList<String>(Arrays.asList("Move", "Search", "Inventory","Fight"));
	private static final int 
		MOVE = 0,
		SEARCH = 1,
		INVENTORY = 2,
		FIGHT = 3;
	
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
	
	// Private Functions for use in other functions //
	int ChoiceInput(String question, ArrayList<String> optionMsgs)
	{
		return FL.InputInt(question + " " + FL.StringifyArrayWithNumbers(optionMsgs)  + "\n>> ", 0, optionMsgs.size());
	}
	// // //
	
	// Getters and Setters //
	public ArrayList<Door> GetAllDoors()
	{
		return exitDoors;
	}
	
	public ArrayList<Enemy> GetAllEnemies()
	{
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		for (Enemy enemy : GameMap.enemies)
		{
			if (enemy.WhereBeThis().equals(this))
				enemies.add(enemy);
		}
		return enemies;
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
	// // //
	
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
	// // //
	
	// The functions that handle each turn's actions //
	public void PlayerTurn(HumanPlayer p)
	{
		int i;
		int choice = FL.InputPlayerInput("What would you like to do? ", playerChoices);
		
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
		case SEARCH:
			
			break;
		case INVENTORY:
			do
			{
				keepGoing = PlayerInventory(p);
			} while (keepGoing);
			break;
		case FIGHT:
			do
			{
				keepGoing = PlayerFight(p);
			} while (keepGoing);
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
		
		
		int choice = FL.InputPlayerInput("Where would you like to move? ", optionMsgs, true);
		--choice; // changes 1 based to 0 based indexing
		
		if (choice < 0) // User chooses to go back to previous menu
		{
			FL.PrintL("YOU CHOSE TO MOVE BACK!");
			return false;
		}
		
		p.MoveTo(exitDoors.get(choice).GetOtherRoom(this));
		return false;
	}
	
	public boolean PlayerInventory(HumanPlayer p)
	{
		int 
			action,
			itemIndex;
		
		ArrayList<String> optionMsgs = new ArrayList<>();
		
		ArrayList<Item> items = p.GetItems();
		for (int i = 0; i < items.size(); i++)
		{
			optionMsgs.add(items.toString());
		}
		
		//int choice = FL.InputInt("Which item would you like to expand? " + FL.StringifyArrayWithNumbers(optionMsgs)  + "\n>> ", 0, optionMsgs.size());
		itemIndex = FL.InputPlayerInput("Which item would you like to expand? ", optionMsgs, true);
		--itemIndex; // changes 1 based to 0 based indexing
		
		if (itemIndex < 0) // User chooses to go back to previous menu
			return false;
		
		action = FL.InputPlayerInput("What would you like to do with it? ", p.GetItems().get(itemIndex).getItemUses(), true);
		
		
		return false;
	}
	
	public boolean PlayerFight(HumanPlayer p)
	{
		ArrayList<String> optionMsgs = new ArrayList<>();
		ArrayList<Enemy> enemies = GetAllEnemies();
		int choice;
		
		if (enemies.size() > 0)
		{
			for (int i = 0; i < enemies.size(); ++i)
			{
				//String otherRoom = enemies.get(i).GetOtherRoom(this).GetName();
				//String otherDirection = FL.StringDirection(enemies.get(i).GetOtherDirection(this));
				optionMsgs.add(enemies.get(i).Name());
			}
		
			choice = FL.InputPlayerInput("Who would you like to fight", optionMsgs, true);
		}
		else
		{
			choice = FL.InputPlayerInput("There are no enemies to fight", optionMsgs, true);
		}
		--choice; // changes 1 based to 0 based indexing
		
		if (choice < 0) // User chooses to go back to previous menu
		{
			FL.PrintL("YOU CHOSE TO DO ANOTHER ACTION!");
			return false;
		}
		
		Enemy enemy = enemies.get(choice);
		if (p.ATTACK(enemy)) //Enemy is STILL ALIVE
			return true;
		else
		{
			GameMap.enemies.remove(enemy);
			return false;
		}
	}
}
