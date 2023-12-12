/**
 * This class defines what an item is in the game.
 * Items are placed in rooms and the player can 
 * interact with them.
 */
public class Item {

	private String name; // Item's name
	private String desc; // Item's description
	private boolean heavy;
	private boolean used;
	
	/**
	 * Constructor - creates a new Item object.
	 * 
	 * @param n Item's name
	 */
	public Item(String n) {
		name = n;
		heavy = false;
		used = false;
	}
	
	public void setHeavy(boolean b) {
		heavy = b;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = b;
	}
	
	/**
	 * Sets the item's description.
	 * 
	 * @param d item's description
	 */
	public void setDesc(String d) {
		desc = d;
	}
	
	/**
	 * Player looks at this item.
	 */
	public void look() {
		Game.print(desc);
	}
	
	/**
	 * Player uses this item.
	 */
	public void use() {
			Game.print("You can't use the "+name+", yet...");
	}
	
	public void take() {
		if(isHeavy()) {
			Game.print("This is too heavy for you!");
		}
		else {
			Game.inventory.add(Game.getCurrentRoom().removeItem(name));
			Game.print("You pick up the "+name+".");
		}
	}
	
	/**
	 * Returns this item's name.
	 * 
	 * @return item's name
	 */
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
}
