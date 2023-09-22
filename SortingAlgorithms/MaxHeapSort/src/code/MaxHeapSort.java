package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeapSort {
	
	static int iteration = 0;

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

		arr.add (5);
		arr.add (8);
		arr.add (3);
		arr.add (9);
		arr.add (4);
		arr.add (1);
		arr.add (7);   				
		
		System.out.println ( arr );
		
		System.out.println ( maxHeapify ( arr ) );	
		
	}
	
	static ArrayList<Integer> maxHeapify ( ArrayList<Integer> arr ) {	
		
		heapify ( arr, arr.size () );
		
		System.out.println ( arr );
		
		while ( iteration < arr.size () - 1 ) {
			
			swapThenHeapify ( arr.subList ( 0, arr.size () - iteration ) );
			
			iteration ++;
			
			System.out.println ( arr );
			
		}
		
		return arr;
		
	}
	
	static void heapify ( List<Integer> list, int parentNode ) {
		
		addNullAtStart ( list );	
		
		while ( parentNode > 0 ) {
						
			Integer parentValue = list.get ( parentNode );
			
			int leftChildIndex = 2 * parentNode;
			
			int rightChildIndex = leftChildIndex + 1;
			
			if ( leftChildIndex > list.size () - 1 ) {
				
				parentNode --;
				
				continue;
				
			} 
			
			Integer leftChildValue = list.get ( leftChildIndex );
			
			Integer biggerChildValue = leftChildValue;
			
			int biggerChildIndex = leftChildIndex;
			
			if ( rightChildIndex > list.size () - 1 ) {
				
			}
			
			else if ( list.get ( rightChildIndex ) != null && list.get ( rightChildIndex ) > leftChildValue ) {
				
				biggerChildValue = list.get ( rightChildIndex );
				
				biggerChildIndex = rightChildIndex;
				
			}
			
			if ( parentValue < biggerChildValue ) {
				
				Collections.swap ( list, parentNode, biggerChildIndex );
					
				parentNode --;
					
			}
			
			else {
				
				parentNode --;
				
			}
			
		}
		
		list.remove ( 0 );		
		
	}
	
	static void swapThenHeapify ( List<Integer> list ) {
			
		Collections.swap ( list, 0, list.size () - 1 );	
		
		List<Integer> subList = list.subList ( 0, list.size () - 1 );
		
		heapify ( subList, subList.size () );
		
	}
	
	static void addNullAtStart ( List<Integer> list ) {
		
		list.add ( 0 );
		
		for ( int index = list.size () - 1; index > 0; -- index ) {
			
			Collections.swap ( list, index, index - 1 );
			
		}
		
		list.set ( 0, null );
		
	}
	
}