package code;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumSmaller {

	public static void main ( String [] args ) {

		int target = 4;
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add ( 5 );
		numbers.add ( 0 );
		numbers.add ( -1 );
		numbers.add ( 3 );
		numbers.add ( 2 );
		
		System.out.println ( threeSumSmaller ( target, numbers ) );

	}
	
	static Integer threeSumSmaller ( Integer target, ArrayList<Integer> numbers ) {
		
		Collections.sort ( numbers );
		
		Integer count = 0;
		
		int focusIndex = 0;
		
		int leftIndex  = 1;
		
		int rightIndex = 2;
		
		while ( focusIndex < numbers.size() - 2 ) {
			
			while ( rightIndex < 0  ) {
				
				int sum = numbers.get ( focusIndex ) + numbers.get ( leftIndex ) + numbers.get ( rightIndex );
				
				if ( sum < target ) {
					
					count ++;										
					
				}

				leftIndex ++;
				
				rightIndex --;
				
			}
			
			focusIndex ++;
			
			leftIndex = focusIndex + 1;
			
			rightIndex = numbers.size() - 1;
			
		}
		
		return count;
		
	}

}
