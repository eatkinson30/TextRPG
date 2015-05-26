package rpgObjectClasses;

import mapInternals.Room;



public class HumanPlayer extends Actor {

	public HumanPlayer(Room startingLocation, String name, int health, int attackPower) {
		super(startingLocation, name, health, attackPower);
	}
	
	public void Start()
	{
		this.location.Enter(this);
	}
	
	public boolean MoveTo(ActorCarrier destination) {
		if (destination instanceof Room) {
			location = (Room)destination;
			return true;
		}
		else
			return false;
	}
	
}
