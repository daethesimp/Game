import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class of the game.
 * 
 * Contains the player's inventory and the main method.
 */
public class Game {

	// Room player is currently in.
	private static Room currentRoom;
	
	// Player's inventory of items.
	private static ArrayList<Item> inventory = new ArrayList<Item>();

	/**
	 * Returns the room the player is currently in.
	 * 
	 * @return current room
	 */
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * Causes the player to move in the given direction
	 * if the direction is valid.
	 * 
	 * @param direction direction player is moving
	 */
	public static void move(char direction) {
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom != null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked!");
			} else {
				currentRoom = nextRoom;
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way!");
		}
	}
	
	/**
	 * Returns the item from the player's inventory
	 * with the given name.
	 * 
	 * @param name name of item to get
	 * @return item from player's inventory
	 */
	public static Item getItem(String name) {
		for(Item i : inventory)
			if(i.getName().equals(name))
				return i;
		return null;
	}
	
	public static void addItem(Item name) {
		inventory.add(name);
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
	/**
	 * Runs the main game loop, which allows the player to
	 * enter commands that the game will respond to.
	 * 
	 * Player commands
	 * 		move to an adjacent room: e, w, n, s, u, d
	 *      display player's inventory: i
	 *      take an item: take
	 *      look at an item: look
	 *      use an item: use
	 *      exit the game: x
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playerCommand = "a";
		String itemName;
		Item i;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		while(!playerCommand.equals("x")) {
			System.out.print("What do you want to do? ");
			playerCommand = scan.nextLine();
			String[] words = playerCommand.split(" ");
			switch(words[0]) {
			case "n":
			case "s":
			case "e":
			case "w":
			case "u":
			case "d":
				move(playerCommand.charAt(0));
				break;
			case "take":
				itemName = words[1];
				if (currentRoom.hasItem(itemName)) {
					inventory.add(currentRoom.removeItem(itemName));
					System.out.println("You pick up the "+itemName+".");
				} else {
					System.out.println("There is no "+itemName+"!");
				}
				break;
			case "look":
				i = getItem(words[1]);
				if (i == null)
					i = currentRoom.getItem(words[1]);
				if (i == null)
					System.out.println("There is no "+words[1]+"!");
				else
					i.look();
				break;
			case "use":
				i = getItem(words[1]);
				if (i == null )
					System.out.println("You don't have the "+words[1]+".");
				else
					i.use();
				break;
			case "i":
				if (inventory.isEmpty()) {
					System.out.println("You are carrying nothing!");
				} else {
					for(Item it : inventory) {
						System.out.println(it);
					}
				}
				break;
			case "x":
				System.out.println("Okay. Bye!");
				break;
			default:
				System.out.println("Invalid command.");
			}
		}
		scan.close();
	}

		
	}














