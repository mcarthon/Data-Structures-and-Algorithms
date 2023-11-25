package code;

import java.math.BigInteger;

public class AddTwoNumbers {

	public static void main ( String [] args ) {

		ListNode l1 = new ListNode ( 1 );
		
		ListNode l2 = new ListNode ( 1 );
		
		ListNode l2tail = l2;
		
		int count = 0;
		
		while ( count < 9 ) {
			
			ListNode newNode = new ListNode(9);
			
			l2tail.next = newNode;
			
			l2tail = l2tail.next;
			
			count ++;
			
		}
		
		l2tail.next = null;
		
		System.out.println ( addTwoNumbers ( l1, l2 ) );

	}
	
	static ListNode addTwoNumbers ( ListNode l1, ListNode l2 ) {
		
		ListNode head = new ListNode(0);

        ListNode tail = head;
        
        l1 = reverseLinkedList ( l1 );
        
        l2 = reverseLinkedList ( l2 );
		
		BigInteger l1Number = linkedListToInt ( l1 );
		
		BigInteger l2Number = linkedListToInt ( l2 );
		
		BigInteger tailNumber = l1Number.add ( l2Number );
		
		String tailString = String.format( "%d", tailNumber );
		
		for ( int index = 0; index < tailString.length(); ++ index ) {
			
			int val = Integer.parseInt ( String.format ( "%s", tailString.charAt ( index ) ) );

            ListNode newNode = new ListNode(val);
			
			tail.next = newNode;
			
			tail = tail.next;
			
		}

        ListNode result = head.next;
		
		head.next = null;
						
		return reverseLinkedList ( result );
		
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
		
		return previous;
		
	}
	
	static BigInteger linkedListToInt ( ListNode head ) {			
		
		String currentString = "";
		
		ListNode current = head;
		
		while ( current != null ) {
			
			currentString += String.format( "%d", current.val );
			
			current = current.next;
			
		}
		
		BigInteger result = new BigInteger ( currentString );
		
		return result;
		
	}

}
