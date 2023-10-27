
public class Shower extends Item{
	
	public Shower() {
		super("shower");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("restroom")) {
				if(Game.getCurrentRoom().hasItem("goo")) {
					Game.print("You washed the the yucky goo away!");
					Game.getCurrentRoom().removeItem("goo");
				}
				else {
					Game.print("Your not dirty!");
				}
			}
		}
	}
