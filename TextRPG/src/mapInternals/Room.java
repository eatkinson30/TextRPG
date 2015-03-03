package mapInternals;

import java.util.ArrayList;

public class Room {
	private int brightness;
	private ArrayList<Door> exitDoors = new ArrayList<Door>();
	
	Room()
	{
		brightness = 3;
	}
	
	Room(int lightLevel, Door... doors)
	{
		
		brightness = lightLevel;
		
		for (Door exit : doors)
			exitDoors.add(exit);
	}
	
	
}
