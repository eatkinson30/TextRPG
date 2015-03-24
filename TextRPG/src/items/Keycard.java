package items;

import main.FL;
import mapInternals.Room;

public class Keycard extends Item {
	private FL.Color keyColor; 
		
	
	public Keycard(Room startingLocation, String name, FL.Color color) {
		super(startingLocation, name);
		
		keyColor = color;		
	}
	
	public FL.Color getColor()
	{
		return keyColor;
	}
}
