import java.util.Scanner;

/**
 * 
 */

/**
 * @author daethesimp
 *
 */
public class StringLab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		char playerCommand = 'a';
		String userPrompt;
		String[] result;
		System.out.println("Enter a sentence ");
		userPrompt = scan.nextLine();
		result = userPrompt.split(" ");
		for(String r: result) {
			System.out.println(r);
			}
		
		
	}

}
