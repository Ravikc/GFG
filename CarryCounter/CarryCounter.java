import java.util.*;
public class CarryCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			String[] nums = scanner.nextLine().split(" ");
			String num1 = nums[0];
			String num2 = nums[1];
			int carry = 0;
			int numberOfCarries = 0;
			
			{
				int len1 = num1.length();
				int len2 = num2.length();
				if(len1 < len2) {
					for(int i = 0; i < len2 - len1; i++) {
						num1 = '0' + num1;
					}
				}
				else if(len2 < len1) {
					for(int i = 0; i < len1 - len2; i++) {
						num2 = '0' + num2;
					}
				}
			}

			for(int i = num1.length() - 1; i >= 0; i--) {
				char ch1 = num1.charAt(i), ch2 = num2.charAt(i);
				int sum = Character.getNumericValue(ch1) + Character.getNumericValue(ch2) + carry;
				if(sum > 9) {
					numberOfCarries++;
					carry = 1;					
				}
				else carry = 0;
			}

			System.out.println(numberOfCarries);
			
		}

		scanner.close();
	} 
}
