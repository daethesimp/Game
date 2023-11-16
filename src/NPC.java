
public class NPC {
	
	private String name;
	private String desc;
	
	public NPC(String name) {
		this.name = name;
	}
	
	public void talk() {
		Game.print("You can't talk to "+name+".");
	}
	
	public void response(int option) {
		
	}
	
	public void say(String dialog) {
		Game.print(name+ " : "+dialog);
	}
	
	/**
	 * Display options to player.
	 * Prompt player to select an option.
	 * Read player's choice.
	 * Call the response method with the player choice
	 * as the parameter.
	 * @param options
	 */
	
	public void getResponse(String[] options) {
		for(int i=0; i<options.length; i++) {
			Game.print("Option " +(i+1)+" : "+options[i]);
		}
		Game.print("Enter an option (1-"+options);
	}
	
	
	
	

}
