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
		
		int count = 0;
		
		for ( int firstIndex = 0; firstIndex < numbers.size () - 2; ++ firstIndex ) {
			
			int firstNumber = numbers.get ( firstIndex );
			
			int secondIndex = firstIndex + 1;
			
			int thirdIndex = numbers.size () - 1;
			
			while ( secondIndex < thirdIndex ) {
				
				int sum = firstNumber + numbers.get ( secondIndex ) + numbers.get ( thirdIndex );
				
				if ( sum < target ) {
					
					count += ( thirdIndex - secondIndex );
					
					secondIndex ++;
					
				}
				
				else {
					
					thirdIndex --;
					
				}
				
			}
			
		}
		
		return count;
		
	}

}
