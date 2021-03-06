package rpgObjectClasses;

import items.Armor;
import items.Item;
import items.ItemCarrier;
import items.Weapon;

import java.lang.reflect.Type;
import java.util.ArrayList;

import main.FL;
import main.Moveable;
import mapInternals.Room;
/*
 * Class for living creatures with health
 */
public abstract class Actor extends Entity implements ItemCarrier, Moveable<ActorCarrier> {
	protected int health;
	protected int maxHealth;
	protected int attackPower;
	protected int armor;
	protected ArrayList<Item> items;
	protected Room location;
	
	public Room WhereBeThis()
	{
		return location;
	}
	
	Actor(Room startingLocation, String name, int health, int attackPower)
	{
		super(name);
		location = startingLocation;
		this.health = health;
		this.maxHealth = health;
		this.attackPower = attackPower;
		this.armor = 0;
		this.items = new ArrayList<Item>();
	}
	
	public abstract boolean MoveTo(ActorCarrier destination);

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
		int damagePowerWithArmor = Math.max(damagePower - ArmorValue(), 1);
		this.health = this.health - damagePowerWithArmor;
		FL.PrintL(this.Name() + " has been attacked by " + attacker.Name() + " and now has " + this.health + " health");
		if (this.health <= 0)
			this.Die(attacker);
		return this.health;
	}
	
	public boolean ATTACK(Actor enemy)
	{
		int power = ModifiedAttackPower();
		FL.PrintL(this.Name() + " is attacking " + enemy.Name() + " for " + power + " damage.");
		return enemy.Damage(power, this) > 0;
	}
	
	public void Die(Actor attacker)
	{
		FL.PrintL(attacker.Name() + " has slain " + this.Name());
		Room here = this.WhereBeThis();
		for (Item item : this.items)
		{
			item.MoveTo(here);
		}
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
	
	public boolean hasItem(Item theThing)
	{
		for (Item item : items) {
			if (item.equals(theThing))
				return true;
		}
		return false;
	}
	
	public ArrayList<Item> GetItems()
	{
		return items;
	}
	
	public int ArmorValue()
	{
		int armorValue = 0;
		for (Item item : this.items)
		{
			if (item.isCarried() && item instanceof Armor && ((Armor)item).IsWearing())
				armorValue += ((Armor)item).Protection();
		}
		this.armor = armorValue;
		return armorValue;
	}
	
	public int ModifiedAttackPower()
	{
		int modifiedAttackPower = this.attackPower;
		for (Item item : this.items)
		{
			if (item.isCarried() && item instanceof Weapon && ((Weapon)item).IsUsing())
				modifiedAttackPower += ((Weapon)item).DamageValue();
		}
		return modifiedAttackPower;
	}
	
	public void EquipArmor(Armor armor)
	{
		for (Item item : this.items)
		{
			if (item.isCarried() && item instanceof Armor)
			{
				Armor armorItem = (Armor)item;
				armorItem.SetIsWearing(armorItem.equals(armor));
			}
		}
	}
	
	public void EquipWeapon(Weapon weapon)
	{
		for (Item item : this.items)
		{
			if (item.isCarried() && item instanceof Weapon)
			{
				Weapon weaponItem = (Weapon)item;
				weaponItem.SetIsUsing(weaponItem.equals(weapon));
			}
		}
	}
}
