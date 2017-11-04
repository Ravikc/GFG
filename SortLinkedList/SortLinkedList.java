import java.util.*;

class Node {
	int value;
	Node next;
	public Node(int i) {
		value = i;
	}
}

public class SortLinkedList {

	

	Node head;

	void linksort() {
		Node zeroHead = null, oneHead = null, twoHead = null;
		Node currZero = null, currOne = null, currTwo = null;
		Node runner = head;
		while(runner != null) {
			if(runner.value == 0) {
				if(zeroHead == null) zeroHead = currZero = runner;
				else {
					currZero.next = runner;
					currZero = runner;
				}
			} else if(runner.value == 1) {
				if(oneHead == null) oneHead = currOne = runner;
				else {
					currOne.next = runner;
					currOne = runner;
				}
			} else if(runner.value == 2) {
				if(twoHead == null) twoHead = currTwo = runner;
				else {
					currTwo.next = runner;
					currTwo = runner;
				}
			}
			
			runner = runner.next;
		}
		
		head = zeroHead;
		currZero.next = oneHead;
		currOne.next = twoHead;
		currTwo.next = null;	
	}  

	public static void main(String[] args) {
		SortLinkedList ll = new SortLinkedList();
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(0);
		ll.head.next.next.next = new Node(1);
		
		ll.linksort();
		while(ll.head != null) {
			System.out.print(ll.head.value + " ");
			ll.head = ll.head.next;
		}
	} 
}
