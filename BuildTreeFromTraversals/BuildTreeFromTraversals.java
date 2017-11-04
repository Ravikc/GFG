import java.util.*;

import javafx.geometry.Pos;
public class BuildTreeFromTraversals {

	private int preIndex = 0;

	private class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	private void postorderTraversal(Node node) {
		if(node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.data);
	}

	private int getIndex(int[] array, int key, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}	

	private Node buildTree(int[] inorder, int[] preorder, int startIndex, int endIndex) {
		if(startIndex > endIndex) return null;
		
		int rootIndex = getIndex(inorder, preorder[preIndex++], startIndex, endIndex);

		


		Node newNode = new Node(inorder[rootIndex]);

		System.out.println("New node: " + newNode.data);

		if(startIndex == endIndex) return newNode;

		
		newNode.left = buildTree(inorder, preorder, startIndex, rootIndex - 1);
		newNode.right = buildTree(inorder, preorder, rootIndex + 1, endIndex);

		return newNode;
	}

	public static void main(String[] args) {
		BuildTreeFromTraversals tree = new BuildTreeFromTraversals();
		int[] inorder = {30, 40, 45, 50, 55, 60, 65};
		int[] preorder = {50, 40, 30, 45, 60, 55, 65};
		Node root = tree.buildTree(inorder, preorder, 0, preorder.length - 1);
		tree.postorderTraversal(root);
	} 
}
