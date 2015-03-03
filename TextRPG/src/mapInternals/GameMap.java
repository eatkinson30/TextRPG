package mapInternals;

import java.util.ArrayList;

/*
 * Contains all the rooms in the game using an array or something like that
 */
public class GameMap {
	private ArrayList<Room> rooms;
	private ArrayList<Door> doors;
	public static final int howManyRooms = 25; // it could be any other number we decide
	
	GameMap()
	{
		rooms = new ArrayList<> (howManyRooms);
		doors = new ArrayList<> (25);
		
		// Initializes Rooms //
		rooms.add(new Room("Lobby", 
				"Description here", 3));
		
		rooms.add(new Room("West Wing",
				"", 3));
		
		rooms.add(new Room("Library",
				"", 3));
		
		rooms.add(new Room("Broom Closet",
				"", 3));
		
		// Creates doors to connect the rooms //
		
		
	}
}
