package rpgObjectClasses;

import mapInternals.Room;
/*
 * Class for living creatures with health
 */
public abstract class Actor extends Entity{
	private int health;
	private int maxHealth;
	private int attackPower;
	private int attackSpeed;
	private int armor;
	
	Actor(Room startingLocation, String name, int health, int attackPower, int attackSpeed, int armor)
	{
		super(startingLocation, name);
		this.health = health;
		this.maxHealth = health;
		this.attackPower = attackPower;
		this.attackSpeed = attackSpeed;
		this.armor = armor;
	}

	public int Health()
	{
		return health;
	}

	public int Heal(int healingPower)
	{
		return health += healingPower;
	}
	
	public int Damage(int damagePower)
	{
		return health -= Math.max(damagePower - this.armor, 1);
	}
	
	public void ATTACK(Actor enemy)
	{
		enemy.Damage(this.attackPower);
	}
}
