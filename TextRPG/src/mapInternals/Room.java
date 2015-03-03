package mapInternals;

import java.util.ArrayList;

public class Room {
	private int brightness;
	private boolean[] exitDirections; // 0 - North, 1 - West, 2 - South, 3 - East
	private ArrayList<Room> exitRooms;
	
	Room()
	{
		
		brightness = 3;
		exitDirections = new boolean[4];
		
		for (int i = 0; i < 4; ++i)
		{
			exitDirections[i] = false;
		}
	}
	
	Room(int lightLevel, Room...rooms)
	{
		
		brightness = lightLevel;
		exitDirections = new boolean[4];
		
		exitDirections[0] = northExit;
		exitDirections[1] = westExit;
		exitDirections[2] = southExit;
		exitDirections[3] = eastExit;		
	}
	
	public void setNorthExit(boolean isExit)
	{
		exitDirections[0] = isExit;
	}
	public void setWestExit(boolean isExit)
	{
		exitDirections[1] = isExit;
	}
	public void setSouthExit(boolean isExit)
	{
		exitDirections[2] = isExit;
	}
	public void setEastExit(boolean isExit)
	{
		exitDirections[3] = isExit;
	}
}
