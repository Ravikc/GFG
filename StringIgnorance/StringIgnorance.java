import java.util.*;
public class StringIgnorance {
	private static void printAlternateOccurance(char[] array) {
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		for(char c : array) {
			char temp = Character.toLowerCase(c);
			if(!hash.containsKey(temp) || hash.get(temp) == 0) {
				hash.put(temp, 1);
				System.out.print(c);
				continue;
			}	

			else if(hash.get(temp) == 1) {
				hash.put(temp, 0);
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			char[] characters = scanner.nextLine().toCharArray();
			printAlternateOccurance(characters);
			System.out.println();
		}
		scanner.close();
	} 
}
