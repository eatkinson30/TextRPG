package mapInternals;

public class Room {
	private int brightness;
	private boolean[] exitDirections; // 0 - North, 1 - West, 2 - South, 3 - East
	
	Room()
	{
		int iterator;
		
		brightness = 3;
		exitDirections = new boolean[4];
		
		for (iterator = 0; iterator < 4; ++iterator)
		{
			exitDirections[iterator] = false;
		}
	}
	
	Room(int lightLevel, boolean northExit, boolean westExit, boolean southExit, boolean eastExit)
	{
		int iterator;
		
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
