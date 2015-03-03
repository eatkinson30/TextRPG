package mapInternals;

import java.util.ArrayList;

public class Room {
	private String 
		name,
		description;
	private int brightness;
	private ArrayList<Door> exitDoors = new ArrayList<Door>();
	
	Room()
	{
		name = "";
		brightness = 3;
	}
	
	Room(String title, int lightLevel)
	{
		name = title;
		brightness = lightLevel;
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
}
