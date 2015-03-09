package mapInternals;

import java.util.ArrayList;
import items.Item;

public class Room {
	private String 
		name,
		desc;
	private int brightness;
	private ArrayList<Door> exitDoors = new ArrayList<Door>();
	private ArrayList<Item> items = new ArrayList<Item>();
	
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
	
	public void Enter()
	{
		
	}
}
