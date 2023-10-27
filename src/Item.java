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
		System.out.println(desc);
	}
	
	/**
	 * Player uses this item.
	 */
	public void use() {
		/*if (name.equals("wand"))
			if(Game.getCurrentRoom().getName().equals("lobby")) {
		       System.out.println("You wave the wand and the lounge magically unlocks!");
		       Room lounge = Game.getCurrentRoom().getExit('e');
		       lounge.setLocked(false);
			} else {
				System.out.println("You wave the wand around.");
			}
		else*/
			System.out.println("You can't use the "+name+", yet...");
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
