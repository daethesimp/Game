
public class Puppy extends NPC{

	public Puppy() {
		super("puppy", "A hideous puppy wags his tail stupidly at ypu.");
		// TODO Auto-generated constructor stub
	}
	
	public void talk() {
		say("Hi! I'm an adorable puppy!");
		String[] options = {
				"Yes you are"
		}
	}

}
