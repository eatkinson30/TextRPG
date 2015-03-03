package items;

public abstract class Item {
	private double weight;
	private String name;
	
	public Item(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public abstract void Use();

}
