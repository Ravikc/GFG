import java.util.*;
public class FourSum {
	private class Quadruple {
		int n1, n2, n3, n4;
		public Quadruple(int i1, int i2, int i3, int i4) {
			n1 = i1;
			n2 = i2;
			n4 = i4;
			n3 = i3;
		}
		@Override 
		public boolean equals(Object obj) {
			if(obj instanceof Quadruple) {
				Quadruple object = (Quadruple) obj;
				return this.n1 == object.n1 && this.n2 == object.n2 && this.n3 == object.n3 && this.n4 == object.n4;
			}
			return false;
		}
		
	}
	
	private void findSum(int[] array, int K, List<Quadruple> set) {
		Arrays.sort(array);
		for(int i = 0; i < array.length - 3; i++) {
			for(int j = i + 1; j < array.length - 2; j++) {
				int twoSum = array[i] + array[j];
				int l = j + 1, r = array.length - 1;
				while(l < r) {
					if(twoSum + array[l] + array[r] == K) {
						if(!set.contains(new Quadruple(array[i], array[j], array[l], array[r])))
							set.add(new Quadruple(array[i], array[j], array[l], array[r]));
						// System.out.print(array[i] + " " + array[j] + " " + array[l] + " " + array[r] + " " + "$");
						l++;
						r--;
					}
					else if(twoSum + array[l] + array[r] < K) {
						l++;
					}
					else {
						r--;
					}
				}				
			}
		}
		for(Quadruple quad : set) {
			System.out.print(quad.n1 +  " " + quad.n2 + " " + quad.n3 + " " + quad.n4 + " " + "$");
		}
	}

	public static void main(String[] args) {
		FourSum fs = new FourSum();

		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int t = 0; t < T; t++) {
			String[] line = scanner.nextLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);
			line = scanner.nextLine().split(" ");
			int[] array = new int[N];
			for(int i = 0; i < N; i++) array[i] = Integer.parseInt(line[i]);
			List<Quadruple> set = new ArrayList<Quadruple>();
			fs.findSum(array, K, set);
			if(set.isEmpty()) System.out.println("-1");
			else System.out.println();
		}
		scanner.close();
	} 
}
