
public class Oldman extends NPC{
	
	public Oldman() {
		super("oldman", "a oldman");
	}
	
	public void talk() {
		say("Zzzz");
		String[] options = {
				"Do you know any directions around here?",
				"Walk away"
		};
		getResponse(options);
	}
	
	public void response(int option) {
		switch(option) {
		case 1:
			say("Zzzzz");
			break;
		case 2:
			Game.print("The old man is sleep");
			break;
		}
	}

}
