import java.util.*;
public class NodesAtDistanceFromLeaf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinaryTree tree = new BinaryTree();
		while(true) {
			System.out.println("1. Insert 2. Nodes at Distane k from leaf");
			switch(Integer.parseInt(scanner.nextLine())) {
				case 1: tree.insert(Integer.parseInt(scanner.nextLine()));
					break;

				case 2: tree.nodesAtDistance(Integer.parseInt(scanner.nextLine()));
					break;

				default: scanner.close();
					return;
			}
		}
	} 
}
