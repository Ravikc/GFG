import java.util.*;
public class MergeKSortedArrays {

	private class Coordinate {
		int row, column;
		public Coordinate(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	private static Coordinate getNextCoordinate(int[][] arrays, int[] columnIndex, int k) {
		Coordinate coordinate = null;
		int minValue = Integer.MAX_VALUE;
		for(int row = 0; row < k; row++) {
			//if the row has not already been exhausted.
			if(columnIndex[row] < k && arrays[row][columnIndex[row]] < minValue) {
				minValue = arrays[row][columnIndex[row]];
				coordinate = new Coordinate(row, columnIndex[row]);
			}
		}

		columnIndex[coordinate.row] += 1;
		return coordinate;
	}

	public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] columnIndex = new int[k];
		while(list.size() < k * k) {
			Coordinate coord = getNextCoordinate(arrays, columnIndex, k);
			list.add(arrays[coord.row][coord.column]);
		}

		return list;
	}

	public static void main(String[] args) {
		//auto-generated code
	} 
}
