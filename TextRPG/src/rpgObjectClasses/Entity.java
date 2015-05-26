package rpgObjectClasses;

/*
 * The class that hopefully will be able to represent all items and characters
 */
public abstract class Entity {
	
	protected String name;
	/* Maybe add more stuff? */
	
	public Entity(String name)
	{
		this.name = name;
	}
	
	public String Name()
	{
		return this.name;
	}
	
	//public abstract boolean MoveTo(EntityCarrier destination);
}
