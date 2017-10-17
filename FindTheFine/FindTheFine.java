import java.util.*;

class FindTheFine {
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static int getFine(int[] carNumbers, int[] penalties, int date) {
        boolean isDateEven = isEven(date);
        int fine = 0;
        for(int i = 0; i < carNumbers.length; i++) {
            //if even date, collect fine from odd car numbers
            if(isDateEven && !isEven(carNumbers[i])) fine += penalties[i];

            //if odd date, collect fine from even number cars
            if(!isDateEven && isEven(carNumbers[i])) fine += penalties[i];
        }
        return fine;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        
        int testCases = scanner.nextInt();
        for(int c = 0; c < testCases; c++) {
            int n = scanner.nextInt();
            int date = scanner.nextInt();
            int index = 0;
            int[] carNumbers = new int[n], penalties = new int[n];        

            for(int i = 0; i < n; i++) carNumbers[index++] = scanner.nextInt();
            index = 0;
            for(int i = 0; i < n; i++) penalties[index++] = scanner.nextInt();

            System.out.println(getFine(carNumbers, penalties, date));

        }

        scanner.close();
    }
}