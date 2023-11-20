package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main ( String [] args ) {
		
		int [] numbers1 = { -1, 0, 1, 2, -1, -4 };
		
		int [] numbers2 = { 0, 1, 1 };
		
		int [] numbers3 = { 0, 0, 0 };
		
		System.out.println ( threeSum ( numbers1 ) );
		
		System.out.println ( threeSum ( numbers2 ) );
		
		System.out.println ( threeSum ( numbers3 ) );

	}
	
	static List<List<Integer>> threeSum ( int [] numbers ) {
		
		Arrays.sort ( numbers );
		
		List<List<Integer>> result = new ArrayList<>();
		
		int focusIndex = 0;
		
		int leftIndex  = 1;
		
		int rightIndex = numbers.length - 1;
		
		while ( focusIndex < numbers.length - 2 ) {
			
			while ( leftIndex < rightIndex ) {
				
				int sum = numbers [ focusIndex ] + numbers [ leftIndex ] + numbers [ rightIndex ];
				
				if ( sum == 0 ) {
					
					List<Integer> newList = new ArrayList<Integer>();
					
					newList.add ( numbers [ focusIndex ] );
					newList.add ( numbers [ leftIndex ] );
					newList.add ( numbers [ rightIndex ] );
					
					result.add ( newList );
					
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
			
			rightIndex = numbers.length - 1;
			
		}
		
		Set<List<Integer>> noDupResult = new HashSet<>( result );
		
		List<List<Integer>> finalResult = new ArrayList<>( noDupResult );
		
		return finalResult;
		
	}

}
