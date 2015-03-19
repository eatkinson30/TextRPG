package items;

public interface ItemCarrier {
	public void addItem(Item theThing);
	public void removeItem(Item theThing);
	public boolean hasItem(Item theThing);
}
