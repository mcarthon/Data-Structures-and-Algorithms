package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumString {

	public static void main ( String [] args ) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add ( 10 );
		arr.add ( 3 );
		arr.add ( -4 );
		arr.add ( 1 );
		arr.add ( -6 );
		arr.add ( 9 );
		
		System.out.println ( threeSum ( arr ) );

	}
	
static ArrayList<String> threeSum ( ArrayList<Integer> arr ) {
		
		Collections.sort ( arr );
		
		ArrayList<String> result = new ArrayList<>();
		
		int focusIndex = 0;
		
		int leftIndex  = 1;
		
		int rightIndex = arr.size () - 1;
		
		while ( focusIndex < arr.size () - 2 ) {
			
			while ( leftIndex < rightIndex ) {
				
				int sum = arr.get ( focusIndex ) + arr.get ( leftIndex ) + arr.get ( rightIndex );
				
				if ( sum == 0 ) {
					
					String string = String.format ( "%d,%d,%d", arr.get ( focusIndex ), arr.get ( leftIndex ), arr.get ( rightIndex ) );					
					
					result.add ( string );
					
					leftIndex ++;
					
					rightIndex --;
					
				}
				
				else if (  sum > 0 ) {
					
					rightIndex --;
					
				}
				
				else {
					
					leftIndex ++;
					
				}
				
			}
			
			focusIndex ++;
			
			leftIndex = focusIndex + 1;
			
			rightIndex = arr.size () - 1;
			
		}
		
		Set<String> noDupResult = new HashSet<String>( result );
		
		ArrayList<String> finalResult = new ArrayList<String>( noDupResult );
		
		return finalResult;
		
	}

}
