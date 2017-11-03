import java.util.*;
public class ReverseList {	

	Node reverse(Node head) {
		Node prev = null, curr = head, next = head.next;
		while(curr.next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}

		curr.next = prev;
		return curr;
	}
	public static void main(String[] args) {
	} 
}
