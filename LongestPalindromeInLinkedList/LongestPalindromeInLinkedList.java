import java.util.*;
public class LongestPalindromeInLinkedList {
	
	private static int getPalindromeLength(Node headA, Node headB) {
		int count = 0;
		while(headA != null && headB != null && headA.data == headB.data) {
			count++;
			headA = headA.next;
			headB = headB.next;
		}
		
		return count;
	}

	public static int maxPalindrome(Node head) {		
		int maxPalindromeLength = 0;
		Node prev = null, curr = head, next = head.next;
		while(curr.next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
			maxPalindromeLength = Math.max(maxPalindromeLength, getPalindromeLength(prev, curr));
			maxPalindromeLength = Math.max(maxPalindromeLength, getPalindromeLength(prev, next));
		}
		return maxPalindromeLength;
	}

	public static void main(String[] args) {
		//auto-generated code here.
	} 
}
