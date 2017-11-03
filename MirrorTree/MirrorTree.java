import java.util.*;
public class MirrorTree {
	void swapChildren(Node node) {
		Node temp;
		temp = node.right;
		node.right = node.left;
		node.left = temp;
	}

	void mirror(Node node) {
		if(node == null || (node.left == null && node.right == null)) return;
		mirror(node.left);		
		mirror(node.right);
		swapChildren(node);
	}

	public static void main(String[] args) {
		//Function type question
	} 
}
