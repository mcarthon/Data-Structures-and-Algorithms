package code;

public class ReverseLinkedList {

	public static void main ( String [] args ) {

		

	}
	
	static ListNode reverseLinkedList ( ListNode head ) {
		
		ListNode current = head;
		
		ListNode previous = null;
		
		while ( current != null ) {
			
			ListNode temp = current.next;
			
			current.next = previous;
			
			previous = current;
			
			current = temp;
			
		}
		
		return head;
		
	}

}
