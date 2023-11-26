
public class Chest extends Item{
	
	private boolean isOpen;
	
	public Chest() {
		super("chest");
		isOpen = false;
	}
	
	public void look() {
		if(isOpen) {
			if(Game.hasItem("key")) {
				
			}
		}
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("attic")) {
			Game.print("u can't use the chest!");
		}
	}

}
