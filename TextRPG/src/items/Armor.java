package items;

import mapInternals.Room;

public class Armor extends Item {
	protected int protection;
	protected boolean isWearing;
	
	public Armor(Room startingLocation, String name, int protection) {
		super(startingLocation, name);
		this.protection = protection;
		this.isWearing = false;
	}
	
	public int Protection()
	{
		return this.protection;
	}
	
	public void SetIsWearing(boolean wearing)
	{
		this.isWearing = wearing;
	}
	
	public boolean IsWearing()
	{
		return isWearing;
	}

}
