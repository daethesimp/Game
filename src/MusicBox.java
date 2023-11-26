
public class MusicBox extends Item {

	public MusicBox() {
		super("music box");
	}

	public void look() {
		Game.print("Plays a mysterious tune that can alter the environment");
	}

	public void use() {
		if (Game.getCurrentRoom().getName().equals("bar")) {
			Game.print("Its blasting heavy metal!");
		}
	}
}
