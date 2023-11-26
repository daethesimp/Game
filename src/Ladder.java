
public class Ladder extends Item {
	
	public Ladder() {
		super("ladder");
	}
	
	public void look() {
		Game.print("Approaching the ladder, you realize its significance – it's your key to freedom.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("outside")) {
			Game.print("You just walked off a 2 story building...");
			Game.print(Game.roomDesc.get("HOTEL_LOSE"));
		} else {
			if(Game.getCurrentRoom().getName().equals("outside")) {
				if(Game.hasItem("ladder")) {
					Game.print("You place the ladder against the wall leading down to the ground level.");
				}
			}
		}
	}
}
