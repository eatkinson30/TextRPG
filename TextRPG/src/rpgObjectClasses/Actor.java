package rpgObjectClasses;

import main.FL;
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
		return this.health = Math.min(this.health + healingPower, this.maxHealth);
	}
	
	public int Damage(int damagePower, Actor attacker)
	{
		int damagePowerWithArmor = Math.max(damagePower - this.armor, 1);
		this.health = Math.min(this.health - damagePowerWithArmor, 0);
		if (this.health == 0)
			this.Die(attacker);
		return this.health;
	}
	
	public void ATTACK(Actor enemy)
	{
		enemy.Damage(this.attackPower, this);
	}
	
	public void Die(Actor attacker)
	{
		FL.PrintLn(attacker.Name() + " has slain " + this.Name());
	}
}
