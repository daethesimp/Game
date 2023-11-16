/**
 * This class constructs the game world.
 */
public class World {

	/**
	 * Build the game world by creating Room objects and connecting
	 * them together.
	 * 
	 * @return the room the player starts the game in
	 */
	public static Room buildWorld() {
		Room lobby = new Room("HOTEL_LOBBY", "The hotel's lobby. Doorways lead east to a lounge"
				+ " and west to a bar. There is a hallway to the north and a "
				+ " staircase up to the second floor.");
		Room lounge = new Room("lounge", "A comfortable lounge with armchairs, a couch, and"
				+ " a delightful fire. An old man with a newspaper in his lap, and a hammer on the arm of the chair"
				+ " sleeps in one of the armchairs.");
		Room bar = new Room("bar", "The hotel bar! There is a long bar along the west wall next to a music box"
				+ " and a door labelled 'Rest Room' to the north. A doorway to the"
				+ " east leads back to the lobby.");
		Room hall = new Room("hall", "A dead-end hallway. A chain hanging from the ceiling. There are doors in the east and"
				+ " west walls. You can return south to the lobby.");
		Room hall2 = new Room("hall2", "You on the hotel's second floor! A staircase leads"
				+ " back down to the lobby.");
		Room restroom = new Room("restroom", "What a pleasant rest room! A huge shower! A sparkly sink! So clean! So fresh!");
		
		lobby.addExit(lounge, 'e');
		lobby.addExit(bar, 'w');
		lobby.addExit(hall, 'n');
		lobby.addExit(hall2, 'u');
		
		lounge.addExit(lobby, 'w');
		Item newspaper = new Item("newspaper");
		newspaper.setDesc("It's a newspaper. Made of paper. What's up with that?");
		lounge.addItem(newspaper);
		lounge.setLocked(true);
		
		bar.addExit(lobby, 'e');
		bar.addExit(restroom, 'n');
		Item bottle = new Item("bottle");
		bottle.setDesc("An opaque glass bottle. Feels empty.");
		bar.addItem(bottle);
		
		restroom.addExit(bar, 's');
		Item wand = new Item("wand");
		wand.setDesc("The wand glows with an eerie light.");
		restroom.addItem(wand);
		
		hall.addExit(lobby, 's');
		
		hall2.addExit(lobby, 'd');
		
		return lobby;
	}
	
}
