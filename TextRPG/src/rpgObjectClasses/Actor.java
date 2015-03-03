package rpgObjectClasses;

import mapInternals.Room;
/*
 * Class for living creatures with health
 */
public class Actor extends Entity{
	private int hitpoints;
	
	Actor(Room startingLocation)
	{
		super(startingLocation);
	}

	public int getHitpoints()
	{
		return hitpoints;
	}

	public void setHitpoints(int hpNew)
	{
		hitpoints = hpNew;
	}
}
