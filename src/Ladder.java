
public class Ladder extends Item {
	
	public Ladder() {
		super("ladder");
	}
	
	public void look() {
		Game.print("Approaching the ladder, you realize its significance – it's your key to freedom.");
	}
	
	public void use() {
		if(Game.hasItem("ladder")) {
			if(Game.getCurrentRoom().getName().equals("outside")) {
					Game.print("You place the ladder against the wall leading down to the ground level.");
					Game.getCurrentRoom().addExit(Game.roomObjects.get("plaza"), 'd');
			}
		}
	}
}
