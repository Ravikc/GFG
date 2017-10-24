import java.util.*;
public class KadanesAlgo {
	private static int kadane(int[] array, int size) {
		if(size < 0) return 0;
		int currentMax = array[0], globalMax = array[0];
		for(int i = 1; i < array.length; i++) {
			currentMax = Math.max(currentMax + array[i], array[i]);
			if(currentMax > globalMax) globalMax = currentMax;
		}
		return globalMax;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			int size = Integer.parseInt(scanner.nextLine());
			String[] line = scanner.nextLine().split(" ");
			int[] array = new int[size];
			for(int i = 0; i < size; i++) array[i] = Integer.parseInt(line[i]);
			System.out.println(kadane(array, size));
		}

		scanner.close();
	} 
}
