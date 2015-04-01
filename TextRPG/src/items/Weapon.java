package items;

import mapInternals.Room;

public class Weapon extends Item {
	protected int damage;
	protected float criticalHitChance;
	protected int criticalHitDamage;
	protected boolean isUsing;
	
	public Weapon(ItemCarrier startingLocation, String name, int damage, int criticalHitDamage, float criticalHitChance) {
		super(startingLocation, name);
		this.damage = damage;
		this.criticalHitDamage = criticalHitDamage;
		this.criticalHitChance = criticalHitChance;
		this.isUsing = false;
	}
	
	public int DamageValue()
	{
		double rand = Math.random();
		return this.damage + (rand <= criticalHitChance ? criticalHitDamage : 0);
	}
	
	public void SetIsUsing(boolean using)
	{
		this.isUsing = using;
	}
	
	public boolean IsUsing()
	{
		return isUsing;
	}

}