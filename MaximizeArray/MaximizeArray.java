import java.util.*;
public class MaximizeArray {
	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static int getIndex(int[] array, int key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) return i;
		}
		return -1;
	}

	private static void reverse(int[] array) {
		int l = 0, r = array.length - 1;
		while(l < r) {
			int temp = array[r];
			array[r] = array[l];
			array[l] = temp;
			l++;
			r--;
		}
	}

	private static int[] removeDuplicates(int[] array) {
		int index = 0;		
		List<Integer> list = new ArrayList<Integer>();
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		for(int num : array) {
			if(!hash.containsKey(num)) {
				hash.put(num, 1);
				list.add(num);
			}
		}
		int[] tempArray = new int[list.size()];
		for(int num : list) tempArray[index++] = num;
		return tempArray;
	}

	private static void maximize(int[] array1, int[] array2, int size) {
		int[] buffer = new int[20], temp = new int[20], tempBuffer = new int[size];

		for(int i = 0; i < size; i++) {
			int value = 10 + (size - i - 1);
			if(value > buffer[array1[i]]) buffer[array1[i]] = value;
			temp[i] = array1[i];
		}
		for(int i = 0; i < size; i++) {
			int value = 20 + (size - i - 1);
			if(value > buffer[array2[i]]) buffer[array2[i]] = value;
			temp[i + size] = array2[i];
		}		

		Arrays.sort(temp);		
		reverse(temp);	
		temp = removeDuplicates(temp);


		// System.out.println("temp array: ");
		// printArray(temp);

		for(int i = 0; i < size; i++) tempBuffer[i] = buffer[temp[i]];
		Arrays.sort(tempBuffer);
		reverse(tempBuffer);

		
		for(int num : tempBuffer) System.out.print(getIndex(buffer, num) + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(scanner.nextLine());
			String[] line1 = scanner.nextLine().split(" ");
			String[] line2 = scanner.nextLine().split(" ");
			int[] array1 = new int[size], array2 = new int[size];
			for(int i = 0; i < size; i++) array1[i] = Integer.parseInt(line1[i]);
			for(int i = 0; i < size; i++) array2[i] = Integer.parseInt(line2[i]);
			maximize(array1, array2, size);
		}
		scanner.close();
	} 
}
