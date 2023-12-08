package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CountingSort {
	
	private int maxDigit;
	
	private HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
	
	private ArrayList<Integer> countingSort ( ArrayList<Integer> array, int place ) {
		
		findMaxAndSetFreq ( array, place );
		
		return generateSortedList ( array, frequencyMap, place );
		
	}

	private int findMaxAndSetFreq ( ArrayList<Integer> arr, int place ) {
		
		maxDigit = ( arr.get ( 0 ) / place ) % 10;
		
		for ( int index = 1; index < arr.size (); ++ index ) {
			
			int currentDigit = ( arr.get ( index ) / place ) % 10;
			
			frequencyMap.put ( currentDigit, frequencyMap.getOrDefault ( currentDigit, 1 ) + 1 );
			
			if ( currentDigit > maxDigit ) {
				
				maxDigit = currentDigit;
				
			}
			
		}
		
		return maxDigit;
		
	}
	
	private ArrayList<Integer> generateSortedList ( ArrayList<Integer> array, HashMap<Integer, Integer> frequencyMap, int place ) {
		
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		for ( int digit = 0; digit < 10 ; ++ digit ) {
			
			if ( frequencyMap.get ( digit ) > 0 ) {
				
				sortedList.addAll ( Collections.nCopies ( frequencyMap.get ( digit ), digit ) );
								
			}
						
		}
		
		return sortedList;		
		
	}
	
}