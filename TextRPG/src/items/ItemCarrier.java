package items;

public interface ItemCarrier {
	public void addItem(Item theThing);
	public void removeItem(Item theThing);
	public int hasItem(Item theThing);
}
