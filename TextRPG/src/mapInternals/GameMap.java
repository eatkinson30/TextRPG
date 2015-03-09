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
	
	public static final int
		LOBBY = 0,
		WESTWING = 1,
		LIBRARY = 2,
		BROOMCLOSET = 3,
		WESTHALL = 4,
		ROBOTCELL = 5,
		SOUTHHALL = 6,
		COURTYARD = 7,
		ARMORCELL = 8,
		SERVERROOM = 9,
		LAB = 10,
		TUNNEL = 10;
	
		
	GameMap()
	{
		Door temp;
		
		rooms = new ArrayList<> (howManyRooms);
		doors = new ArrayList<> (25);
		
		// Initializes Rooms //
		rooms.set(LOBBY, new Room("Lobby", // 0
				"This is the main lobby of facility 57. The main entrance lies to the north", 3));
		
		rooms.set(WESTWING, new Room("West Wing", // 1
				""));
		
		rooms.set(LIBRARY, new Room("Library", // 2
				""));
		
		rooms.set(BROOMCLOSET, new Room("Broom Closet", // 3
				""));
		
		rooms.set(WESTHALL, new Room("West Hall", // 4
				""));
		
		rooms.set(ROBOTCELL, new Room("Robot Cell", // 5
				""));
		
		rooms.set(SOUTHHALL, new Room("Southern Hallway", // 6
				""));
		
		rooms.set(COURTYARD, new Room("Courtyard", // 7
				""));
		
		rooms.set(ARMORCELL, new Room("Armor Statue Cell", // 8
				""));
		
		rooms.set(SERVERROOM, new Room("Server Room", // 9
				""));
		
		rooms.set(LAB, new Room("Laboratory", // 10
				""));
		
		rooms.set(TUNNEL, new Room("Tunnel", // 11
				""));
		
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
		
		temp = new Door(rooms.get(2), rooms.get(4), Direction.SOUTH, Direction.NORTH); // Connects Library and West Hall
		rooms.get(2).GetAllDoors().add(temp);
		rooms.get(4).GetAllDoors().add(temp);
		
		temp = new Door(rooms.get(4), rooms.get(5), Direction.SOUTH, Direction.NORTH); // Connects West Hall and Robot Cell
		rooms.get(4).GetAllDoors().add(temp);
		rooms.get(5).GetAllDoors().add(temp);
	}
}
