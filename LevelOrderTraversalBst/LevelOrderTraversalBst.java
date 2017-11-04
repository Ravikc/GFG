import java.util.*;

public class LevelOrderTraversalBst {
	private void levelOrder(Node root) {
		if(root == null) return;
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while(!list.isEmpty()) {
			Node removed = list.removeFirst();
			System.out.print(removed.data + " ");
			if(removed.left != null) list.add(removed.left);
			if(removed.right != null) list.add(removed.right);	
		}
	}
	
	public static void main(String[] args) {
		//auto generated code.
	} 
}
