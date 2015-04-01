package mapInternals;

import java.util.ArrayList;

import rpgObjectClasses.Actor;
import rpgObjectClasses.Enemy;
import main.FL.Direction;

/*
 * Contains all the rooms in the game using an array or something like that
 */
public class GameMap {
	private static ArrayList<Room> rooms;
	private static ArrayList<Door> doors;
	public static ArrayList<Enemy> enemies;
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
		TUNNEL = 11;
	
		
	public static void _GameMap()
	{
		Door temp;
		
		rooms = new ArrayList<Room>(25);
		doors = new ArrayList<Door>(25);
		enemies = new ArrayList<Enemy>();
		
		// Initializes Rooms //
		rooms.add(LOBBY, new Room("Lobby", // 0
				"This is the main lobby of facility 57. The main entrance lies to the north", 3));
		
		rooms.add(WESTWING, new Room("West Wing", // 1
				""));
		
		rooms.add(LIBRARY, new Room("Library", // 2
				""));
		
		rooms.add(BROOMCLOSET, new Room("Broom Closet", // 3
				""));
		
		rooms.add(WESTHALL, new Room("West Hall", // 4
				""));
		
		rooms.add(ROBOTCELL, new Room("Robot Cell", // 5
				""));
		
		rooms.add(SOUTHHALL, new Room("Southern Hallway", // 6
				""));
		
		rooms.add(COURTYARD, new Room("Courtyard", // 7
				""));
		
		rooms.add(ARMORCELL, new Room("Armor Statue Cell", // 8
				""));
		
		rooms.add(SERVERROOM, new Room("Server Room", // 9
				""));
		
		rooms.add(LAB, new Room("Laboratory", // 10
				""));
		
		rooms.add(TUNNEL, new Room("Tunnel", // 11
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
		
		enemies.add(new Enemy(rooms.get(WESTWING), "BOSS", 100, 10));
	}
	
	public static Room GetRoom(int index)
	{
		return rooms.get(index);
	}
}
