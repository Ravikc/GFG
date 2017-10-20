import java.util.*;
public class NonRepeatingCharacterInStream {
	private static void printFirstNonRepeating(String str, Hashtable<String, Integer> hash) {
		for(char c : str.toCharArray()) {
			//System.out.println("Checking for char : " + c);
			if(hash.get(String.valueOf(c)) > 1) continue;
			else {
				System.out.print(c + " ");
				return;
			}
		}

		System.out.print("-1" + " ");
	}

	private static void getNonRepeatingCharacter(String[] array) {
		// System.out.println("The array is");
		// for(String str : array) System.out.println(str);
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		StringBuilder sb = new StringBuilder();
		for(String c : array) {			
			sb.append(c);
			if(!hash.containsKey(c)) {
				hash.put(c, 1);
				//System.out.println("Putting key: " + c);
			}
			else {
				int value = hash.get(c);
				hash.put(c, value + 1);
				//System.out.println("incrementing key : " + c);
			}
			printFirstNonRepeating(sb.toString(), hash);
			
		}		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			scanner.nextLine();
			String line = scanner.nextLine();
			getNonRepeatingCharacter(line.split(" "));
			System.out.println();
		}
		scanner.close();
	} 
}
