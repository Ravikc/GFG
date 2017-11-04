public class LinkedListIntersection {
    private int getLength(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        int difference = Math.abs(length1 - length2);
        
        ListNode bigRunner, smallRunner;
        if(length1 > length2) {
            bigRunner = headA;
            smallRunner = headB;
        } else {
            bigRunner = headB;
            smallRunner = headA;
        }
        
        while(difference-- != 0) bigRunner = bigRunner.next;
        while(bigRunner != smallRunner) {
            bigRunner = bigRunner.next;
            smallRunner = smallRunner.next;
        }
        
        return smallRunner;
	}
	
	public static void main(String[] args) {
		//auto-generated code.
	}
}