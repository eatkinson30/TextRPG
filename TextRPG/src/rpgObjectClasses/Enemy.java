package rpgObjectClasses;

import mapInternals.Room;

public class Enemy extends Actor {

	public Enemy(Room startingLocation, String name, int health, int attackPower) {
		super(startingLocation, name, health, attackPower);
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
