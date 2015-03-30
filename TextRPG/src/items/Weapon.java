package items;

import mapInternals.Room;

public class Weapon extends Item {
	protected int damage;
	protected float criticalHitChance;
	protected int criticalHitDamage;
	
	public Weapon(Room startingLocation, String name, int damage, int criticalHitDamage, float criticalHitChance) {
		super(startingLocation, name);
		this.damage = damage;
		this.criticalHitDamage = criticalHitDamage;
		this.criticalHitChance = criticalHitChance;
	}
	
	public int DamageValue()
	{
		double rand = Math.random();
		return this.damage + (rand <= criticalHitChance ? criticalHitDamage : 0);
	}

}