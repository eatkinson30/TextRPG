package items;

import mapInternals.Room;

public class Armor extends Item {
	protected int protection;
	
	public Armor(Room startingLocation, String name, int protection) {
		super(startingLocation, name);
		this.protection = protection;
	}
	
	public int Protection()
	{
		return this.protection;
	}

}
