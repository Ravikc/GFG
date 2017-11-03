import java.util.*;
public class IsIsomorphic {
	public boolean isIsomorphic(Node root1, Node root2) {
		if(root1 == null && root2 == null) return true;
		if((root1 == null || root2 == null) || root1.data != root2.data) return false;
		
		return isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right) ||
				isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
   	}

	public static void main(String[] args) {
		//auto-generated code
	} 
}
