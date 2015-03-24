package items;

import mapInternals.Room;

public class Keycard extends Item {
	private int keyColor; 
		
	
	public Keycard(Room startingLocation, String name, int color) {
		super(startingLocation, name);
		
		keyColor = color;		
	}
	
	public int getColor()
	{
		return keyColor;
	}
}
