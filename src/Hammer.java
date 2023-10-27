
public class Hammer extends Item{
	
	public Hammer() {
		super("hammer");
	}
	
	public void look() {
		Game.print("Can be used to break objects or create new paths");
		
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("lounge")) {
			if(Game.getCurrentRoom().hasItem("hammer")){
				Game.print("You killed the old man! How dare you!");
				
			}
		}
	}

}
