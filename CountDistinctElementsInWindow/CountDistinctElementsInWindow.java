import java.util.*;
public class CountDistinctElementsInWindow {
	
	void countDistinct(int array[], int k, int n) {
		HashSet<Integer> set;
		for(int i = 0; i < n; i+= 4) {
			set = new HashSet<Integer>();
			for(int j = i; j < i + 4; j++) {
				set.add(array[j]);
			}
			System.out.print(set.size() + " ");
		} 
	}
	
	public static void main(String[] args) {
		//auto-generated code.
	} 
}
