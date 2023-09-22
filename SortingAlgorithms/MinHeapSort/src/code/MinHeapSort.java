package code;

import java.util.ArrayList;

public class MinHeapSort {

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
		
		System.out.println ( minHeapify ( arr ) );

	}
	
	static ArrayList<Integer> minHeapify ( ArrayList<Integer> arr ) {	
		
		heapify ( arr, 1 );
		
		ArrayList<Integer> minHeap = new ArrayList<Integer> ();
		
		while ( arr.size () > 0 ) {
			
			Integer currentMin = extractMin ( arr );
			
			minHeap.add ( currentMin );
			
		}
		
		return minHeap;
		
	}
	
	static void heapify ( ArrayList<Integer> arr, int parentNode ) {
		
		addNullAtStart ( arr );	
		
		while ( parentNode < arr.size() ) {
						
			Integer parentValue = arr.get ( parentNode );
			
			int leftChildIndex = 2 * parentNode;
			
			int rightChildIndex = leftChildIndex + 1;
			
			if ( leftChildIndex > arr.size () - 1 ) {
				
				parentNode ++;
				
				continue;
				
			} 
			
			Integer leftChildValue = arr.get ( leftChildIndex );
			
			Integer rightChildValue = ( rightChildIndex > arr.size () - 1 ) ? parentValue + leftChildValue : arr.get ( rightChildIndex );
			
			if ( parentValue > leftChildValue || parentValue > rightChildValue ) {
				
				if ( leftChildValue <= rightChildValue ) {
					
					swap ( arr, parentNode, leftChildIndex );
					
					parentNode = 1;
					
				}
				
				else if ( rightChildValue < leftChildValue ) {
					
					swap ( arr, parentNode, rightChildIndex );
					
					parentNode = 1;
					
				}
				
			}
			
			else {
				
				parentNode ++;
				
			}
			
		}
			
		arr.remove ( 0 );
							
	}
	
	static Integer extractMin ( ArrayList<Integer> arr ) {
		
		Integer tentativeMin = arr.get ( 0 );
		
		if ( arr.size () > 1 ) {
			
			swap ( arr, 0, arr.size () - 1 );			
			
		}
		
		arr.remove ( arr.size () - 1 );
		
		heapify ( arr, 1 );
		
		return tentativeMin;
		
	}
	
	static void addNullAtStart ( ArrayList<Integer> arr ) {
		
		arr.add ( 0 );
		
		for ( int index = arr.size () - 1; index > 0; -- index ) {
			
			swap ( arr, index, index - 1 );
			
		}
		
		arr.set ( 0, null );
		
	}
	
	static void swap ( ArrayList<Integer> arr, int i, int j ) {
		
		int temp = arr.get( i );
		
		arr.set ( i, arr.get ( j ) );
		
		arr.set ( j, temp );
		
	}

}
