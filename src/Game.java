import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> roomDesc = new HashMap<>();
	public static HashMap<String, Room> roomObjects = new HashMap<>(); //keys of the map will be room names and the values will be room objects
	
	
	
	public static void setHashMap(HashMap<String, String> roomDesc) {
		roomDesc.equals(roomDesc);
	}
	
	public static void HashMapAdd(String roomID, String desc) {
		roomDesc.put(roomID, desc);
	}
	
	public static String getValue(String roomID) {
		return roomDesc.get(roomID);
	}
	
	//String getValue("HOTEL_LOUNGE");
	
	public static void readFile() {
		Scanner scan;
		try {
			scan = new Scanner(new File("roomDesc"));
			while(scan.hasNextLine()) {
				String lineID = scan.nextLine();
				String lineDesc = scan.nextLine();
				String line = scan.nextLine();
				roomDesc.put(lineID, lineDesc);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void saveGame() {
		try {
			File saveFile = new File("save");
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(roomObjects);
		} catch (FileNotFoundException ex) {
			Game.print("Error accessing save file.");
		} catch (IOException ex) {
			Game.print("Error creating save file.");
			ex.printStackTrace();
		}
	}
	
	public static void loadGame() {
		try {
			File loadFile = new File("load");
			loadFile.createNewFile();
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(loadFile));
			currentRoom = (Room) stream.readObject();
			inventory = (ArrayList<Item>) stream.readObject();
			roomObjects = (HashMap<String, Room>) stream.readObject();
		} catch (FileNotFoundException ex) {
			Game.print("Error accessing load file.");
		} catch (IOException ex) {
			Game.print("Error creating load file.");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

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
	
	public static boolean hasItem(String name) {
		return getItem(name) != null;
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
		readFile();
		String playerCommand = "a";
		String itemName;
		String NPCname;
		Item i;
		NPC j;
		currentRoom = World.buildWorld();
		System.out.println("Welcome to the Hotel Adventure! Your goal is to explore the hotel, interact with characters, and uncover the mysteries within. Navigate through different rooms and areas to discover the secrets hidden within the hotel. Can you solve puzzles, interact with the characters, and find your way to the ultimate destination? Good luck!");
		System.out.println("Controls: move to an adjacent room: e, w, n, s, u, d || display player's inventory: i || talk to an character: talk || take an item: take || look at an item: look || use an item: use || exit the game: x");
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
			case "talk":
				NPCname = words[1];
				if(currentRoom.hasNPC(NPCname)) {
					currentRoom.getNPC(NPCname).talk();
				} else {
					System.out.print("There is no" + NPCname + "!");
				}
				break;
			case "take":
				itemName = words[1];
				if (currentRoom.hasItem(itemName)) {
					currentRoom.getItem(itemName).take();
				} else {
					System.out.println("There is no "+itemName+"!");
				}
				break;
			case "look":
				i = getItem(words[1]);
				NPCname = words[1];
				//j = getNPC(words[1]);
				if(currentRoom.hasNPC(NPCname)){
					currentRoom.getNPC(NPCname).look();
				} else {
					System.out.println("There is no" + NPCname+ "!");
				}
				if (i == null)
					i = currentRoom.getItem(words[1]);
				if (i == null)
					System.out.println("There is no "+words[1]+"!");
				else
					i.look();
				break;
			case "use":
				i = getItem(words[1]);
				if (i == null) {
					i = currentRoom.getItem(words[1]);
				}
				if(i == null) {
					System.out.print("You can use this item right now!");
					
				} else {
					i.use();
				}
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
			case"save":
				Game.saveGame();
				Game.print("Game saved!");
				break;
			case"load":
				Game.loadGame();
				Game.print("Game load!");
				break;
			default:
				System.out.println("Invalid command.");
			}
		}
		scan.close();
	}

		
	}














