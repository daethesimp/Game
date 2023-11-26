
public class Flashlight extends Item{
	
	public Flashlight() {
		super("flashlight");
		setDesc("Its a flashlight!");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("office")) {
			Game.print("You can now see the office!");
			Game.print(Game.roomDesc.get("HOTEL_OFFICE_2"));
			
		} else {
			Game.print("You're not in the office.");
		}
	}
	
	
	
	
	
	

}
