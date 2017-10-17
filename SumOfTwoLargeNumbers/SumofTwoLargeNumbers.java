import java.util.*;

public class SumofTwoLargeNumbers {
    private static String add(int[] num1, int[] num2) {
        int carry = 0;
        String result = "";       

        int i = num1.length - 1;
        while(i >= 0 || carry == 1) {
            if(i < 0) {               
                result = carry + result;               
                break;
            }

            int sum = num1[i] + num2[i] + carry;
            if(sum > 9) {
                carry = 1;
                sum = sum % 10;
            }
            else {
                carry = 0;
            }

            result = String.valueOf(sum) + result;   
            i--;
        }   
        return result;
    }

    private static String add(String str1, String str2) {
        int bigger = Math.max(str1.length(), str2.length());
        int smaller = Math.min(str1.length(), str2.length());        
        String biggerString, smallerString;
        if(str1.length() > str2.length()) {
            biggerString = str1;
            smallerString = str2;
        }
        else{
            biggerString = str2;
            smallerString = str1;
        }
        
        for(int i = 0; i < bigger - smaller; i++) {
            smallerString = '0' + smallerString;
        }

        int[] num1 = new int[bigger], num2 = new int[bigger];
        for(int i = 0; i < bigger; i++) {
            num1[i] = Character.getNumericValue(smallerString.charAt(i));
            num2[i] = Character.getNumericValue(biggerString.charAt(i));
        }

        return add(num1, num2);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for(int c = 0; c < testCases; c++) {
            String[] line = scanner.nextLine().split(" ");
            String num1 = line[0];
            String num2 = line[1];
            String result = add(num1, num2); 
            if(num1.length() == result.length()) System.out.println(result);
            else System.out.println(num1);
        }
        scanner.close();
    }
}