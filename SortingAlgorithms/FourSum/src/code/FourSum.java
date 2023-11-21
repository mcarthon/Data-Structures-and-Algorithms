package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FourSum {		

	public static void main ( String [] args ) {

		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2));
		
		int Target = 0;
		
		System.out.println ( four_sum ( array, Target ) );
		
		
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		
		int Target1 = 20;
		
		System.out.println ( four_sum ( array1, Target1 ) );
		
		
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
		
		int Target2 = 10;
		
		System.out.println ( four_sum ( array2, Target2 ) );
		
		
		ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));
		
		int Target3 = -1;
		
		System.out.println ( four_sum ( array3, Target3 ) );
		
		
		ArrayList<Integer> array4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		int Target4 = 20;
		
		System.out.println ( four_sum ( array4, Target4 ) );
		

		
		ArrayList<Integer> array5 = new ArrayList<>(Arrays.asList(251, 251, 251, 251, 251, 251, 251, 251));
		
		int Target5 = 1004;
		
		System.out.println ( four_sum ( array5, Target5 ) );

	}
	
	static ArrayList<ArrayList<Integer>> four_sum(ArrayList<Integer> array, Integer target) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if ( array.size() < 4 ) {
			
			return result;
			
		}
		
		Collections.sort ( array );
		
		HashSet<ArrayList<Integer>> quadSet = new HashSet<ArrayList<Integer>>();
		
		for ( int firstIndex = 0; firstIndex < array.size() - 3; ++ firstIndex ) {
			
			if ( firstIndex > 0 && array.get ( firstIndex - 1 ) == array.get ( firstIndex )  ) {
				
				continue;
				
			}
			
			int firstInt = array.get ( firstIndex ); 
			
			for ( int secondIndex = firstIndex + 1; secondIndex < array.size() - 2; ++ secondIndex ) {
				
				if ( secondIndex > firstIndex + 1 && array.get ( secondIndex - 1 ) == array.get ( secondIndex ) ) {
					
					continue;
					
				}
				
				int secondInt = array.get ( secondIndex );
				
				int thirdIndex = secondIndex + 1;
				
				int fourthIndex = array.size() - 1;
				
				while ( thirdIndex < fourthIndex ) {
					
					int sum = firstInt + secondInt + array.get ( thirdIndex ) + array.get ( fourthIndex );
					
					if ( sum < target ) {
						
						do {
							
							thirdIndex ++;							
							
						}
						
						while ( thirdIndex < array.size() && array.get ( thirdIndex - 1 ).equals ( array.get ( thirdIndex ) ) );
						
					}
					
					else if ( sum > target ) {
						
						do {
							
							fourthIndex --;							
							
						}
						
						while ( fourthIndex > thirdIndex && array.get ( fourthIndex + 1 ).equals ( array.get ( fourthIndex ) ) );
						
					}
					
					else {
						
						ArrayList<Integer> quadruplet = new ArrayList<Integer>();
						
						quadruplet.add ( firstInt );
						quadruplet.add ( secondInt );
						quadruplet.add ( array.get ( thirdIndex ) );
						quadruplet.add ( array.get ( fourthIndex ) );
						
						if ( quadSet.add ( quadruplet ) ) {
                        
                            result.add(quadruplet);
                        
                        }
						
						do {
							
							thirdIndex ++;							
							
						}
						
						while ( thirdIndex < array.size() && array.get ( thirdIndex - 1 ).equals ( array.get ( thirdIndex ) ) );											
						
					}
					
				}
				
			}
			
		}
		
		return result;
		
	}
	
}