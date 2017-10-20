import java.util.*;
public class DfsGraphTest {
	private static void readMatrix(String line, char[][] matrix, int rows, int columns) {
		int row = 0, col = 0;
		String[] values = line.split(" ");
		for(int i = 0; i < rows * columns; i++) {
			if(i != 0 && i % columns == 0) {
				row++;
				col = 0;
			}
			matrix[row][col++] = values[i].charAt(0);
		}
	}

	private static boolean isValid(int currentRow, int currentColumn, int rows, int columns) {
		return currentRow >= 0 && currentRow < rows && currentColumn >= 0 && currentColumn < columns;
	}

	private static void DFS(char[][] matrix, boolean[][] visited, int rows, int columns, int currentRow, int currentColumn, 
							List<String> dictionaryWords, HashSet<String> foundWords, String currentString) {

		
		
		if(visited[currentRow][currentColumn]) return;		
		visited[currentRow][currentColumn] = true;

		currentString += matrix[currentRow][currentColumn];

		System.out.println("Processsing: " + currentString);
								
		if(dictionaryWords.contains(currentString)) foundWords.add(currentString);
		
		
		for(int i = currentRow - 1; i <= currentRow + 1; i++) {
			for(int j = currentColumn - 1; j <= currentColumn + 1; j++) {
				if(isValid(i, j, rows, columns)) {
					// currentString += matrix[i][j];
					DFS(matrix, visited, rows, columns, i, j, dictionaryWords, foundWords, currentString);
					// currentString = currentString.substring(0, currentString.length());
				} 
			}
		}
		currentString = currentString.substring(0, currentString.length());
		
		// WHY <------- ???
		visited[currentRow][currentColumn] = false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < testCases; t++) {
			//number of words in the dictionary
			scanner.nextLine();

			//read all the words in the dictionary
			String[] dictionary = scanner.nextLine().split(" ");

			//Dimension of the boggle
			String[] dims = scanner.nextLine().split(" ");
			int rows = Integer.parseInt(dims[0]);
			int columns = Integer.parseInt(dims[1]);

			HashSet<String> foundWords = new HashSet<String>();
			char[][] matrix = new char[rows][columns];
			boolean[][] visited = new boolean[rows][columns];
	
			readMatrix(scanner.nextLine(), matrix, rows, columns);
	
			List<String> dictionaryWords = Arrays.asList(dictionary);

			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++) {
				//	visited = new boolean[rows][columns];					
					DFS(matrix, visited, rows, columns, i, j, dictionaryWords, foundWords, "");
				}
			}

			List<String> sorted = new ArrayList<String>(foundWords);
			Collections.sort(sorted);
			for(String found : sorted) System.out.println(found);
		}
		scanner.close();
	} 
}
