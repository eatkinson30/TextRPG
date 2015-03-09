package mapInternals;

import java.util.ArrayList;

import main.FL.Direction;

/*
 * Contains all the rooms in the game using an array or something like that
 */
public class GameMap {
	private ArrayList<Room> rooms;
	private ArrayList<Door> doors;
	public static final int howManyRooms = 25; // it could be any other number we decide
	
	GameMap()
	{
		Door temp;
		
		rooms = new ArrayList<> (howManyRooms);
		doors = new ArrayList<> (25);
		
		// Initializes Rooms //
		rooms.add(new Room("Lobby",
				"This is the lobby, the first room that you came to when you entered the facility. The main entrance lies to the north", 3));
		
		rooms.add(new Room("West Wing",
				"", 3));
		
		rooms.add(new Room("Library",
				"", 3));
		
		rooms.add(new Room("Broom Closet",
				"", 3));
		
		// Creates doors to connect the rooms //
		
		temp = new Door(rooms.get(0), rooms.get(1), Direction.WEST, Direction.EAST); // Connects Lobby and West Wing
		rooms.get(0).GetAllDoors().add(temp);
		rooms.get(1).GetAllDoors().add(temp);
		
		temp = new Door(rooms.get(1), rooms.get(2), Direction.SOUTH, Direction.NORTH); // Connects West Wing and Library
		rooms.get(1).GetAllDoors().add(temp);
		rooms.get(2).GetAllDoors().add(temp);
		
		temp = new Door(rooms.get(2), rooms.get(3), Direction.NORTH, Direction.SOUTH); // Connects Closet and Library
		rooms.get(2).GetAllDoors().add(temp);
		rooms.get(3).GetAllDoors().add(temp);
		
	}
}
