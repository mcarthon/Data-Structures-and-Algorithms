package code;

import java.util.ArrayList;

public class Segregate {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add ( -2 );
		
		arr.add ( -1 );
		
		arr.add ( 0 );
		
		arr.add ( 1 );
		
		arr.add ( 2 );
		
		System.out.println ( partition ( arr ) );

	}
	
	static ArrayList<Integer> partition ( ArrayList<Integer> arr ) {
		
		int leftPointer = 0;
		
		int rightPointer = arr.size () - 1;
		
		boolean swapLeftPointer = false;
		
		boolean swapRightPointer = false;
		
		while ( leftPointer < rightPointer ) {
			
			if ( arr.get ( leftPointer ) % 2 == 0 ) {
				
				leftPointer ++;
				
			}
			
			else {
				
				swapLeftPointer = true;
				
			}
			
			if ( arr.get ( rightPointer ) % 2 != 0 ) {
				
				rightPointer --;
				
			}
			
			else {
				
				swapRightPointer = true;
				
			}
			
			if ( swapLeftPointer && swapRightPointer ) {
				
				swap ( arr, leftPointer, rightPointer );
				
				swapLeftPointer = false;
				
				swapRightPointer = false;
				
				leftPointer ++;
				
				rightPointer --;
				
			}
			
		}
		
		return arr;
		
	}
	
	static void swap ( ArrayList<Integer> arr, int leftIndex, int rightIndex ) {
		
		Integer temp = arr.get ( leftIndex );
		
		arr.set ( leftIndex, arr.get ( rightIndex ) );
		
		arr.set ( rightIndex, temp );
		
	}

}
