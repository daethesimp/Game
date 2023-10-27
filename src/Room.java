import java.util.HashMap;

/**
 * This class describes what a room is in the game.
 * The rooms are linked together and represent the game
 * world. The player can travel from one room to another.
 */
public class Room {

	// What other rooms is this room connected to?
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	
	// This room's description to display to the player.
	private String desc;
	
	private boolean locked; // Is the room locked?
	private String name; // Name of this room
	
	// Map of items placed in this room.
	private HashMap<String, Item> roomItems;
	
	/**
	 * Constructor - creates a new Room object.
	 * 
	 * @param n Room's name
	 * @param d Room's description.
	 */
	public Room(String n, String d) {
		name = n;
		desc = d;
		locked = false;
		roomItems = new HashMap<String, Item>();
	}
	
	/**
	 * Return the name of this room.
	 * 
	 * @return Room's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Is this room locked?
	 * 
	 * @return true if room is locked
	 */
	public boolean isLocked() {
		return locked;
	}
	
	/**
	 * Locks or unlocks this room.
	 * @param b true/false, is the room locked?
	 */
	public void setLocked(boolean b) {
		locked = b;
	}
	
	/**
	 * Returns the item with the given name
	 * if that item is in this room, or null
	 * otherwise.
	 * 
	 * @param item item's name
	 * @return item or null
	 */
	public Item getItem(String item) {
		return roomItems.get(item);
	}
	
	/**
	 * Remove the specified item from this room.
	 * @param name Item's name
	 * @return removed Item object
	 */
	public Item removeItem(String name) {
		return roomItems.remove(name);
	}
	
	/**
	 * Adds this given Item to this room.
	 * @param i Item to add
	 */
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	/**
	 * Returns true if the specified Item is in this
	 * room, and false otherwise.
	 * @param name Item's name
	 * @return true if item is in this room
	 */
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	/**
	 * Returns this room's description.
	 * 
	 * @return Room's description
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * Connects this room to the given room in the specified
	 * direction (e, w, n, s, u, or d).
	 * 
	 * @param r Room to connect this room to
	 * @param direction direction of the connection
	 */
	public void addExit(Room r, char direction) {
		switch(direction) {
		case 'e': east = r; break;
		case 'w': west = r; break;
		case 'n': north = r; break;
		case 's': south = r; break;
		case 'u': up = r; break;
		case 'd': down = r; break;
		}
	}

	/**
	 * Returns the room the player will travel to
	 * if they move in the specified direction, or null
	 * if there is no room in that direction.
	 * 
	 * @param direction direction the player is moving in
	 * @return the room the player travels to, or null
	 */
	public Room getExit(char direction) {
		switch(direction) {
		case 'e': return east;
		case 'w': return west;
		case 'n': return north;
		case 's': return south;
		case 'u': return up;
		case 'd': return down;
		default : return null;
		}
	}
	
	public String toString() {
		return desc;
	}
	
}
