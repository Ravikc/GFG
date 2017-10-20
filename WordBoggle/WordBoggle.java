import java.util.*;
public class WordBoggle {
	private class Coordinate {
		public int x, y;		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private Coordinate getCoordinate(char[][] matrix, char c) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == c) return new Coordinate(i, j);
			}
		}
		return null;
	}

	private boolean areAdjacent(Coordinate coord1, Coordinate coord2) {
		int row1 = coord1.x;
		int col1 = coord1.y;

		int row2 = coord2.x;
		int col2 = coord2.y;

		int rowDiff = Math.abs(row1 - row2);
		int colDiff = Math.abs(col1 - col2);

		return rowDiff <= 1 && colDiff <= 1 && (rowDiff != 0 || colDiff != 0);
	}

	//return true if the given word is present in the matrix;
	private boolean isPresent(char[][] matrix, String word) {
		ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		for(char c : word.toCharArray()) {
			Coordinate coord = getCoordinate(matrix, c);
			if(coord == null) return false;
			else list.add(coord);
		}

		for(int i = 1; i < list.size(); i++) {
			if(!areAdjacent(list.get(i - 1), list.get(i))) return false;
		}

		return true;
	}

	private void printMatrix(char[][] matrix, int rows, int columns) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void readMatrix(char[][] matrix, int rows, int columns) {
		Scanner scanner = new Scanner(System.in);
		int row = 0, col = 0;
		String[] values = scanner.nextLine().split(" ");
		for(int i = 0; i < rows * columns; i++) {
			if(i != 0 && i % columns == 0) {
				row++;
				col = 0;
			}
			matrix[row][col++] = values[i].charAt(0);
		}

		scanner.close();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		WordBoggle wb = new WordBoggle();

		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			scanner.nextLine();
			String[] words = scanner.nextLine().split(" ");
			String[]  dimension = scanner.nextLine().split(" ");
			int rows = Integer.parseInt(dimension[0]);
			int columns = Integer.parseInt(dimension[1]);

			char[][] matrix = new char[rows][columns];
			wb.readMatrix(matrix, rows, columns);
			wb.printMatrix(matrix, rows, columns);
			
			HashSet<String> set = new HashSet<String>();
			for(String word : words) {
				if(wb.isPresent(matrix, word)) set.add(word);
			}	
			
			List<String> list = new ArrayList<String>(set);
			Collections.sort(list);

			if(list.isEmpty()) System.out.println("-1");
			else {
				for(String word : list) System.out.print(word + " ");
			}

			System.out.println();
		}
		scanner.close();
	} 
}
