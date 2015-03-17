package rpgObjectClasses;

import items.Item;
import items.ItemCarrier;

import java.util.ArrayList;

import main.FL;
import mapInternals.Room;
/*
 * Class for living creatures with health
 */
public abstract class Actor extends Entity implements ItemCarrier{
	protected int health;
	protected int maxHealth;
	protected int attackPower;
	protected int attackSpeed;
	protected int armor;
	protected ArrayList<Item> items;
	protected Room location;
	
	public Room WhereBeThis()
	{
		return location;
	}

	public void MoveTo(Room locationNew)
	{
		location = locationNew;
		location.Enter(this);
	}
	
	Actor(Room startingLocation, String name, int health, int attackPower, int attackSpeed, int armor)
	{
		super(name);
		location = startingLocation;
		this.health = health;
		this.maxHealth = health;
		this.attackPower = attackPower;
		this.attackSpeed = attackSpeed;
		this.armor = armor;
		this.items = new ArrayList<Item>();
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
		FL.PrintL(attacker.Name() + " has slain " + this.Name());
	}
	
	public void PickUpItem(Item item)
	{
		items.add(item);
		FL.PrintL(this.Name() + "has picked up a " + item.Name());
	}
	
	// Item Functions //
	public void addItem(Item theThing)
	{
		items.add(theThing);
	}
	public void removeItem(Item theThing)
	{
		items.remove(theThing);
	}
}
