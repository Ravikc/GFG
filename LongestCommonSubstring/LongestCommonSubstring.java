import java.util.*;
public class LongestCommonSubstring {
	private static boolean isValidIndex(int i, int j, int[][] matrix, int rows, int columns) {		
		return i >= 0 && j >= 0 && i < rows && j < columns;
	}

	private static int getValue(int[][] matrix, int rows, int columns, int i, int j) {
		if(isValidIndex(i - 1, j - 1, matrix, rows, columns)) return matrix[i - 1][j - 1];
		return 0;
	}

	private static int getLongestCommonSubstringLength(String str1, String str2, int[][] matrix, int rows, int columns) {
		int max = 0;
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					int value = 1 + getValue(matrix, rows, columns, i, j);
					if(value > max) max = value;
					matrix[i][j] = value;					
				}
				else {
					matrix[i][j] = 0;
				}
			}	
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());

		for(int t = 0; t < T; t++) {
			scanner.nextLine();
			String str1 = scanner.nextLine(), str2 = scanner.nextLine();			
			int[][] matrix = new int[str1.length()][str2.length()];
			System.out.println(getLongestCommonSubstringLength(str1, str2, matrix, str1.length(), str2.length()));
		}
		scanner.close();
	} 
}
