package code;

import java.util.ArrayList;

public class MergeKsortedLists {

	public static void main ( String [] args ) {
		
		ListNode head1 = new ListNode (0);
		
		ListNode head1next = new ListNode (2);
		
		ListNode head1nextnext = new ListNode (4);
		
		head1.next = head1next;
		
		head1next.next = head1nextnext;
		
		ListNode head2 = new ListNode (-1);
		
		ListNode head2next = new ListNode (0);
		
		ListNode head2nextnext = new ListNode (3);
		
		head2.next = head2next;
		
		head2next.next = head2nextnext;
		
		ListNode head3 = null;
		
		ListNode head4 = new ListNode (-15);
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		
		lists.add(head1);
		
		lists.add(head2);
		
//		lists.add(head3);
		
		lists.add(head4);
		
		printLinkedList ( merge_k_lists ( lists ) );
		
	}
	
	static ListNode merge_k_lists ( ArrayList<ListNode> lists ) {
		
		if ( lists.size() == 0 ) {
			
			return null; 
			
		}
		
		while ( lists.size() > 1 ) {
			
			ArrayList<ListNode> mergedLists = new ArrayList<ListNode>();
			
			for ( int index = 0; index < lists.size(); index += 2 )  {
				
				ListNode firstHalf = lists.get ( index );
				
				if  ( index + 1 < lists.size() ) {
					
					ListNode secondHalf = lists.get ( index + 1 );
					
					mergedLists.add ( merge ( firstHalf, secondHalf ) );
					
				}
				
				else {
					
				ListNode secondHalf = null;
				
				mergedLists.add ( merge ( firstHalf, secondHalf ) );
				
				}
				
			}						
			
			lists = mergedLists;
			
		}
		
		return lists.get(0);
		
	}
	
	static ListNode merge ( ListNode firstHalf, ListNode secondHalf ) {
		
		ListNode fhRunner = firstHalf;
		
		ListNode shRunner = secondHalf;
		
		ListNode dummyHead = new ListNode(0);
		
		ListNode tail = dummyHead;
		
		while ( fhRunner != null && shRunner != null ) {
			
			if ( fhRunner.val < shRunner.val ) {
				
				ListNode newNode = new ListNode ( fhRunner.val );
				
				tail.next = newNode;
				
				tail = tail.next;
				
				fhRunner = fhRunner.next;
				
			}
			
			else {
				
				ListNode newNode = new ListNode ( shRunner.val );
				
				tail.next = newNode;
				
				shRunner = shRunner.next;
				
				tail = tail.next;
				
			}
			
		}
		
		while ( fhRunner != null ) {
			
			ListNode newNode = new ListNode ( fhRunner.val );
			
			tail.next = newNode;
			
			tail = tail.next;
			
			fhRunner = fhRunner.next;
			
		}
		
		while ( shRunner != null ) {
			
			ListNode newNode = new ListNode ( shRunner.val );
			
			tail.next = newNode;
			
			tail = tail.next;
			
			shRunner = shRunner.next;
			
		}
		
		ListNode result = dummyHead.next;
		
		dummyHead.next = null;
		
		return result;
		
	}
	
	static void printLinkedList ( ListNode node ) {
		
		while ( node != null ) {
			
			System.out.println ( node.val );
			
			node = node.next;
			
		}
		
	}
	
}