import java.util.*;
public class KnightWalk {
	private static boolean isValid(int x, int y, int rows, int columns) {
		return x >= 0 && x < rows && y >= 0 && y < columns;
	}

	private static void dfs(int sx, int sy, int dx, int dy, int rows, int columns, boolean[][] visited, List<Integer> countList, int steps) {
		// System.out.println("I am at: " + sx + ", " + sy + " Count: + " + steps);
		
		if(sx == dx && sy == dy) {
			countList.add(steps);
			return;
		}
		if(visited[sx][sy]) return;
		visited[sx][sy] = true;

		int[] directionX = { -2 , -2 , 2 , 2 , 1 , 1 , -1 , -1 };
		int[] directionY = { 1 , -1 , 1 ,-1 , 2 , -2 , 2 , -2 };
		for(int i = 0; i < 8; i++) {
			if(isValid(sx + directionX[i], sy + directionY[i], rows, columns)) {				
				dfs(sx + directionX[i], sy + directionY[i], dx, dy, rows, columns, visited, countList, steps + 1);
				// visited[sx + directionX[i]][sy + directionY[i]] = false;
				// visited[sx][sy] = false;

			}
			// visited[sx][sy] = false;
		}
		visited[sx][sy] = false;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			String[] line = scanner.nextLine().split(" ");
			int rows = Integer.parseInt(line[0]);
			int columns = Integer.parseInt(line[1]);
			
			line = scanner.nextLine().split(" ");
			int s1 = Integer.parseInt(line[0]);
			int s2 = Integer.parseInt(line[1]);
			int d1 = Integer.parseInt(line[2]);
			int d2 = Integer.parseInt(line[3]);

			boolean[][] visited = new boolean[rows][columns];
			List<Integer> countList = new ArrayList<Integer>();

			dfs(s1 - 1, s2 - 1, d1 - 1, d2 - 1, rows, columns , visited, countList, 0);

			System.out.println(Collections.min(countList));
		}

		scanner.close();
	} 
}
