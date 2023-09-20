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
		
		ArrayList<Integer> minHeap = new ArrayList<Integer> ();
		
		while ( arr.size () > 0 ) {
			
			Integer currentMin = extractMin ( arr );
			
			insert ( minHeap, currentMin );
			
		}
		
		return minHeap;
		
	}
	
	static void insert ( ArrayList<Integer> arr, Integer newInt ) {
		
		arr.add ( newInt );		
		
		checkIfMinHeap ( arr, arr.size () - 1 );
		
	}
	
	static Integer extractMin ( ArrayList<Integer> arr ) {
		
		Integer tentativeMin = arr.get ( 0 );
		
		for ( int index = 1; index < arr.size (); ++ index ) {
			
			if ( arr.get ( index ) < tentativeMin ) {
				
				tentativeMin = arr.get ( index ); 
				
			}
			
		}
		
		int indexOfTentativeMin = arr.indexOf ( tentativeMin );
		
		arr.remove ( indexOfTentativeMin );
		
		return tentativeMin;
		
	}
	
	static boolean checkIfMinHeap ( ArrayList<Integer> arr, int index ) {
		
		addNullAtStart ( arr );
		
		int parentIndex = index / 2;
		
		if ( parentIndex == 0 ) {
		
			arr.remove ( 0 );
		
			return true;
		
		}
		
		int leftChildIndex = 2 * parentIndex;
		
		int rightChildIndex = 2 * parentIndex + 1; 
		
		Integer parent = arr.get ( parentIndex );
		
		Integer leftChild = arr.get ( leftChildIndex );
		
		Integer rightChild = arr.get ( rightChildIndex );
		
		if ( parent == null || leftChild == null ) {
		
			arr.remove ( 0 );
		
			return true;
		
		} 
		
		if ( rightChild == null ) {
		
			rightChild = leftChild + parent;
		
		}
		
		if ( leftChild < parent && leftChild < rightChild ) {
			
			swap ( arr, parentIndex, leftChildIndex );
			
			checkIfMinHeap ( arr, parentIndex );
			
		}
		
		else if ( rightChild < parent && rightChild < leftChild ) {
			
			swap ( arr, parentIndex, rightChildIndex );
			
			checkIfMinHeap ( arr, parentIndex );
			
		}
		
		arr.remove ( 0 );  
		
		return true;
		
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
