package rpgObjectClasses;

import items.Item;
import items.ItemCarrier;
import mapInternals.Room;

public class HumanPlayer extends Actor {

	public HumanPlayer(Room startingLocation, String name, int health, int attackPower, int attackSpeed, int armor) {
		super(startingLocation, name, health, attackPower, attackSpeed, armor);
	}
	
	public void Start()
	{
		this.location.Enter(this);
	}
}
