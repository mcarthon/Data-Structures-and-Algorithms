package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CountingSort {
	
	static int min;
	
	static int max;

	public static void main( String[] args ) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

		arr.add ( 3 );
		arr.add ( -3 );
		arr.add ( 2 );
		arr.add ( 2 );
		arr.add ( 0 );
		arr.add ( 1 );
		arr.add ( -2 );
		arr.add ( -2 );
		
		System.out.println ( arr );
		
		max = findMax ( arr );
		
		min = findMin ( arr );
		
		HashMap<Integer, Integer> frequencyMap = setMap ( min, max );
		
		frequencyMap = findCounts ( frequencyMap, arr );
		
		System.out.println ( frequencyMap );
		
		ArrayList<Integer> finalAnswer = generateSortedList ( frequencyMap );
		
		System.out.println ( finalAnswer );

	}
	
	static int findMax ( ArrayList<Integer> arr ) {
		
		Integer max = arr.get ( 0 );
		
		for ( int index = 1; index < arr.size (); ++ index ) {
			
			if ( arr.get ( index ) > max ) {
				
				max = arr.get ( index );
				
			}
			
		}
		
		return max;
		
	}
	
	static int findMin ( ArrayList<Integer> arr ) {
		
		Integer min = arr.get ( 0 );
		
		for ( int index = 1; index < arr.size (); ++ index ) {
			
			if ( arr.get ( index ) < min ) {
				
				min = arr.get ( index );
				
			}
			
		}
		
		return min;
		
	}
	
	static HashMap<Integer, Integer> setMap ( int min, int max ) {
		
		HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		
		for ( int integer = min; integer < max + 1; ++ integer ) {
			
			frequencyMap.put ( integer, 0 );
			
		}
		
		return frequencyMap;
		
	}
	
	static HashMap<Integer, Integer> findCounts ( HashMap<Integer, Integer> frequencyMap, ArrayList<Integer> arr ) {
		
		for ( Integer integer : arr ) {
			
			frequencyMap.put ( integer, frequencyMap.get ( integer ) + 1 );
			
		}
		
		return frequencyMap;
		
	}
	
	static ArrayList<Integer> generateSortedList ( HashMap<Integer, Integer> frequencyMap ) {
		
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		for ( Integer integer = min; integer < max + 1; ++ integer ) {
			
			if ( frequencyMap.get ( integer ) > 0 ) {
				
				sortedList.addAll ( Collections.nCopies ( frequencyMap.get ( integer ), integer ) );
								
			}
						
		}
		
		return sortedList;		
		
	}

}