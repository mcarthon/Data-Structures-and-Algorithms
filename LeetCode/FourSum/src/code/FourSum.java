package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	public static void main ( String [] args ) {
		
		int [] array = { 1000000000, 1000000000, 1000000000, 1000000000 };
		
		long Target = -294967296L;
		
		System.out.println ( fourSum ( array, Target ) );
		
	}
	
	static List<List<Integer>> fourSum( int [] array, long target ) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if ( array.length < 4 ) {
			
			return result;
			
		}
		
		Arrays.sort ( array );
		
		HashSet<ArrayList<Integer>> quadSet = new HashSet<ArrayList<Integer>>();
		
		for ( int firstIndex = 0; firstIndex < array.length - 3; ++ firstIndex ) {
			
			if ( firstIndex > 0 && array[ firstIndex - 1 ] == array[ firstIndex ]  ) {
				
				continue;
				
			}
			
			int firstInt = array[ firstIndex ]; 
			
			for ( int secondIndex = firstIndex + 1; secondIndex < array.length - 2; ++ secondIndex ) {
				
				if ( secondIndex > firstIndex + 1 && array[ secondIndex - 1 ] == array[ secondIndex ] ) {
					
					continue;
					
				}
				
				int secondInt = array[ secondIndex ];
				
				int thirdIndex = secondIndex + 1;
				
				int fourthIndex = array.length - 1;
				
				while ( thirdIndex < fourthIndex ) {
					
					long sum = (long) firstInt + secondInt + array[ thirdIndex ] + array[ fourthIndex ];
					
					if ( sum < target ) {
						
						do {
							
							thirdIndex ++;							
							
						}
						
						while ( thirdIndex < array.length && array[ thirdIndex - 1 ] == array[ thirdIndex ] );
						
					}
					
					else if ( sum > target ) {
						
						do {
							
							fourthIndex --;							
							
						}
						
						while ( fourthIndex > thirdIndex && array[ fourthIndex + 1 ] == array[ fourthIndex ] );
						
					}
					
					else {
						
						ArrayList<Integer> quadruplet = new ArrayList<Integer>();
						
						quadruplet.add ( firstInt );
						quadruplet.add ( secondInt );
						quadruplet.add ( array[ thirdIndex ] );
						quadruplet.add ( array[ fourthIndex ] );
						
						if ( quadSet.add ( quadruplet ) ) {
                        
                            result.add(quadruplet);
                        
                        }
						
						do {
							
							thirdIndex ++;							
							
						}
						
						while ( thirdIndex < array.length && array[ thirdIndex - 1 ] == array[ thirdIndex ] );											
						
					}
					
				}
				
			}
			
		}
		
		return result;
		
	}
	
}
