package mapInternals;
/*
 * Contains all the rooms in the game using an array or something like that
 */
public class GameMap {
	private Room[] rooms;
	public static final int howManyRooms = 25; // it could be any other number we decide
	
	GameMap()
	{
		int iterator;
		
		rooms = new Room[howManyRooms];
		
		for (iterator = 0; iterator < howManyRooms; ++iterator)
		{
			rooms[iterator] = new Room();
		}
	}
}
