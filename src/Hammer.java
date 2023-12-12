import javax.swing.JOptionPane;

public class Hammer extends Item {

	public Hammer() {
		super("hammer");
	}

	public void look() {
		Game.print("Can be used to break objects or create new paths");

	}

	public void use() {
		if (Game.hasItem("hammer")) {
			if (Game.getCurrentRoom().getName().equals("lounge")) {
				String command = JOptionPane.showInputDialog(null, "What would you use it for?");
				if (command.equalsIgnoreCase("Attack oldman")) {
					Game.print("You killed the old man! How dare you!");
				}
			}
			if (Game.getCurrentRoom().getName().equals("hall2")) {
				Game.print("What would you use it for?");
				String command_2 = JOptionPane.showInputDialog(null, "What would you use it for?");
				if (command_2.equalsIgnoreCase("Break wall")) {
					Game.getCurrentRoom().getExit('e').setLocked(false);
					Game.getCurrentRoom().getExit('w').setLocked(false);
					Game.print("the walls now turned into path ways to the east  and west");
				}
			}
			// if(command == "Hit wall!") {
			// Game.print(command);
			// }
		}
	}

}
