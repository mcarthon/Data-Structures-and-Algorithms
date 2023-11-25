package code;

public class MergeTwoSortedLinkedLists {

	public static void main ( String [] args ) {

		ListNode head1 = new ListNode();
//		
//		ListNode newNode1 = new ListNode(2);
//		
//		ListNode newNode2 = new ListNode(4);
//		
//		head1.next = newNode1;
//		
//		head1.next.next = newNode2;
		
		ListNode head2 = new ListNode(1);
		
		ListNode newNode3 = new ListNode(3);
		
		ListNode newNode4 = new ListNode(4);
		
		head2.next = newNode3;
		
		head2.next.next = newNode4;
		
		System.out.println ( mergeTwoLists ( head1, head2 ) );
		

	}
	
	static ListNode mergeTwoLists ( ListNode l1, ListNode l2 ) {
		
		if ( l1 == null ) {
			
			return l2;
			
		}
		
		if ( l2 == null ) {
			
			return l1;
			
		}
		
		ListNode dummyHead = new ListNode( 0 );
		
		ListNode dummyTail = dummyHead;
		
		ListNode l1Pointer = l1;
		
		ListNode l2Pointer = l2;
		
		while ( l1Pointer != null && l2Pointer != null ) {
			
			if ( l1Pointer.val <= l2Pointer.val ) {
				
				ListNode newNode = new ListNode( l1Pointer.val );
				
				dummyTail.next = newNode;
				
				dummyTail = dummyTail.next;
				
				l1Pointer = l1Pointer.next;
				
			}
			
			else {
				
				ListNode newNode = new ListNode( l2Pointer.val );
				
				dummyTail.next = newNode;
				
				dummyTail = dummyTail.next;
				
				l2Pointer = l2Pointer.next;
				
			}
			
		}
		
		while ( l1Pointer != null ) {
			
			ListNode newNode = new ListNode( l1Pointer.val );
			
			dummyTail.next = newNode;
			
			dummyTail = dummyTail.next;
			
			l1Pointer = l1Pointer.next;
			
		}
		
		while ( l2Pointer != null ) {
			
			ListNode newNode = new ListNode( l2Pointer.val );
			
			dummyTail.next = newNode;
			
			dummyTail = dummyTail.next;
			
			l2Pointer = l2Pointer.next;
			
		}
		
		ListNode result = dummyHead.next;
		
		dummyHead.next = null;
		
		dummyTail.next = null;
		
		ListNode runner = result;
		
		while ( runner != null ) {
			
			System.out.println ( runner.val );
			
			runner = runner.next;
			
		}
		
		return result;
		
	}

}
