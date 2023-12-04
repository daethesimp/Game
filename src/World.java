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
		Room lobby = new Room("lobby", "HOTEL_LOBBY");
		Room lounge = new Room("lounge", "HOTEL_LOUNGE");
		Room bar = new Room("bar", "HOTEL_BAR");
		Room hall = new Room("hall", "HOTEL_HALL");
		Room hall2 = new Room("hall2", "HOTEL_HALL_2");
		Room restroom = new Room("restroom", "HOTEL_RESTROOM");
		Room office = new Room("office" , "HOTEL_OFFICE");
		Room kitchen = new Room("kitchen" , "HOTEL_KITCHEN");
		Room basement = new Room("basement" , "HOTEL_BASEMENT");
		Room attic = new Room("attic" , "HOTEL_ATTIC");
		Room outside = new Room("outside" , "HOTEL_OUTSIDE");
		Room secretChamber = new Room("secret chamber" , "HOTEL_SECRET_CHAMBER");
		Room plaza = new Room("plaza" , "HOTEL_PLAZA");
		
		lobby.addExit(lounge, 'e');
		lobby.addExit(bar, 'w');
		lobby.addExit(hall, 'n');
		lobby.addExit(hall2, 'u');
		lobby.addExit(office, 's');
		lobby.addExit(basement, 'd');
		
		lounge.addExit(lobby, 'w');
		Item newspaper = new Item("newspaper");
		newspaper.setDesc("It's a newspaper. Made of paper. What's up with that?");
		lounge.addItem(newspaper);
		NPC puppy = new NPC("puppy");
		lounge.addNPC(puppy);
		NPC oldman = new NPC("old man");
		lounge.addNPC(oldman);
		//lounge.setLocked(true);
		lounge.addExit(kitchen, 'n');
		
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
		Chain c = new Chain();
		c.setHeavy(true);
		hall.addItem(c);
		
		
		hall2.addExit(lobby, 'd');
		hall2.addExit(plaza, 'e');
		plaza.setLocked(true);
		hall2.addExit(secretChamber, 'w');
		secretChamber.setLocked(true);
		hall2.addExit(attic, 'u');
		//hall2.addExit(, 0);
		
		kitchen.addExit(lounge, 's');
		
		basement.addExit(lobby, 'u');
		
		office.addExit(lobby, 'n');
		
		attic.addExit(hall2, 'd');
		Item chest = new Item("chest");
		chest.setDesc("wooden chest with heavnly sounds");
		attic.addItem(chest);
		
		outside.addExit(hall2, 'w');
		outside.addExit(plaza, 'd');
		
    	secretChamber.addExit(hall2, 'e');
		
		return lobby;
	}
	
}
