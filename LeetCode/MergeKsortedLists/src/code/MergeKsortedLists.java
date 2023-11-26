package code;

public class MergeKsortedLists {

	public static void main ( String [] args ) {
		
		ListNode head1 = new ListNode ( 1 );
		
		ListNode newNode1 = new ListNode ( 4 );
		
		ListNode newNode2 = new ListNode ( 5 );
		
		head1.next = newNode1;
		
		newNode1.next = newNode2;
		
		ListNode head2 = new ListNode ( 1 );
		
		ListNode newNode3 = new ListNode ( 3 );
		
		ListNode newNode4 = new ListNode ( 4 );
		
		head2.next = newNode3;
		
		newNode3.next = newNode4;
		
		ListNode head3 = new ListNode ( 2 );
		
		ListNode newNode5 = new ListNode ( 6 );
		
		head3.next = newNode5;
		
		ListNode [] lists = { head1, head2, head3 };
		
		System.out.println ( mergeKLists ( lists ) );
		
		ListNode head4 = new ListNode ( 0 );
		
		ListNode [] lists2 = { head4.next };
		
		System.out.println ( mergeKLists ( lists2 ) );
		
		ListNode head5 = new ListNode ( 1 );
		
		ListNode head6 = new ListNode ( 0 );
		
		ListNode [] lists3 = { head5, head6 };
		
		System.out.println ( mergeKLists ( lists3 ) );

	}
	
	static ListNode mergeKLists ( ListNode [] lists ) {
		
		ListNode dummyHead = new ListNode ( 0 );
		
		ListNode tail = dummyHead;
		
		for ( int index = 0; index < lists.length; ++ index ) {
			
			ListNode currentHead = lists [ index ];
				
			tail = mergeLists ( currentHead, tail, index );
			
		}
		
		ListNode result = dummyHead.next;
		
		dummyHead.next = null;
		
		printLinkedList ( result );
		
		return result;
		
	}

	static ListNode mergeLists ( ListNode l1, ListNode tailHead, int iteration ) {
		
		ListNode l1Runner = l1;
		
		ListNode tail = tailHead;
		
		while ( l1Runner != null && tail.next != null ) {
			
			if ( l1Runner.val <= tail.val ) {
				
				ListNode newNode = new ListNode ( l1Runner.val );
				
				ListNode originalNext = tail.next;
				
				tail.next = newNode;
				
				tail.next.next = originalNext;
				
				tail = tail.next;
				
				l1Runner = l1Runner.next;
				
			}
			
			else if ( l1Runner.val < tail.next.val ) {
								
				ListNode newNode = new ListNode ( l1Runner.val );
				
				ListNode originalNext = tail.next;
				
				tail.next = newNode;
				
				tail.next.next = originalNext;
				
				tail = tail.next;
				
				l1Runner = l1Runner.next;
				
			}
			
			else {
				
				tail = tail.next;
				
			}
			
		}
		
		while ( l1Runner != null ) {
			
			ListNode newNode = new ListNode ( l1Runner.val );
			
			ListNode originalNext = tail.next;
			
			tail.next = newNode;
			
			newNode.next = originalNext;
			
			tail = tail.next;
			
			l1Runner = l1Runner.next;
			
		}
		
		if ( iteration < 1 ) {
			
			return tailHead.next;
			
		}
		
		return tailHead;

	}
	
	static void printLinkedList ( ListNode head ) {
		
		while ( head != null ) {
			
			System.out.println ( head.val );
			
			head = head.next;
			
		}
		
	}
	
}