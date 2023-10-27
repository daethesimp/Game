
public class Chain extends Item{
	
	public Chain() {
		super("chain");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("hall")) {
			if(isUsed()) {
				Game.print("The chain is on the floor covered in goo");
			} else {
				Game.print("You pull the chain and goo is poured all over you!");
				Item goo = new Item("goo");
				goo.setDesc("Eww!");
				Game.getCurrentRoom().addItem(goo);
				Game.addItem(goo);
				setUsed(true);
			}
		}
	}

}
