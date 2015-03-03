package mapInternals;

import java.util.ArrayList;

/*
 * Contains all the rooms in the game using an array or something like that
 */
public class GameMap {
	private ArrayList<Room> rooms;
	public static final int howManyRooms = 25; // it could be any other number we decide
	
	GameMap()
	{
		rooms = new ArrayList<> (howManyRooms);
		
		rooms.add(new Room());
	}
}
