
public class Puppy extends NPC{
	
	private boolean talkedToOnce = false;
	private boolean talkedToTwice = false;

	public Puppy() {
		super("puppy");
		// TODO Auto-generated constructor stub
	}
	
	public void talk1() {
		say("Hi! I'm an adorable puppy!");
		String[] options = {
				"Yes you are Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
		};
		getResponse(options);
	}
	
	public void talk2() {
		say("Hey! Wanna play fetch? Say yes! Say yes!");
		String[] more_options = {
				"Yes! I love fetch!",
				"No. I am a horrible person and dont like playing with puppies."
		};
		getResponse(more_options);
	}
	public void talk3() {
		say("Yip!");
		}
		
	
	
	public void response1(int option) {
		switch(option) {
		case 1:
			say("I am! I'm a good boy!");
			break;
		case 2:
			say("I am to adorable! Why are you so mean?");
			Game.print("The puppy bites you. You deserve it.");
			break;
		}
	}
	public void response2(int option) {
		switch(option) {
		case 1:
			say("Yay! Fetch! (The puppy runs off and returns with a ball. The player receives the ball.)");
			break;
		case 2:
			say("You're a bad person! I dont like you! (The puppy runs away and dosen't come back.");
			break;
		}
	}
	
	public void talk() {
		if(!talkedToOnce) {
			talk1();
			talkedToOnce = true;
		} else if (!talkedToTwice) {
			talk2();
			talkedToTwice = true;
		} else {
			talk3();
		}
	}
	
	public void response(int dialog, int option) {
		switch(dialog) {
		case 1:
			response1(option);
			break;
		case 2:
			response2(option);
			break;
		}
	}

}
