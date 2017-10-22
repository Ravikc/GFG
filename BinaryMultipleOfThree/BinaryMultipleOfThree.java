import java.util.*;
public class BinaryMultipleOfThree {
	private static int isMultipleOfThree(String number) {
		int sum = 0;
		for(int i = 0; i < number.length(); i += 4) {
			String nibble = number.substring(i, i + 4);			
			sum += Integer.valueOf(nibble, 2);
		}
		if(sum % 3 == 0) return 1;
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			String number = scanner.nextLine();			

			//make the length divisible by 4
			for(int i = 0; i < number.length() % 4; i++) number = '0' + number;

			System.out.println(isMultipleOfThree(number));
		}


		scanner.close();
	} 
}
