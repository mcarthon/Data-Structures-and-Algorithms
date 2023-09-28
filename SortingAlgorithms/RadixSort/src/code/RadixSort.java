package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.*;

public class RadixSort {
	
	static ArrayList<String> arrStrings = new ArrayList<String>();
	
	static int maxLength = 0;
	
	static int max;
	
	static int min;
	
	static boolean negNumPresent = false;

	public static void main( String[] args ) {		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add ( 00 );
		
		arr.add ( 101 );
		
		arr.add ( 12 );
		
		arr.add ( -9999 );
		
		arr.add ( -6 );
		
		stringifyAndMaxLength ( arr );
		
		addZeros ();
		
		System.out.println ( arrStrings );
		
	}
	
	static void stringifyAndMaxLength ( ArrayList<Integer> arr ) {
		
		for ( int index = 0; index < arr.size (); ++ index ) {
			
			arrStrings.add ( String.valueOf ( arr.get ( index ) ) );
			
			boolean numIsNegative = arrStrings.get ( index ).indexOf ( '-' ) != -1;
			
			boolean numIsPositive = arrStrings.get ( index ).indexOf ( '-' ) == -1;
			
			boolean newMaxLength = arrStrings.get ( index ).length() > maxLength; 
			
			if ( numIsNegative && newMaxLength ) {
				
				negNumPresent = true;
				
				maxLength = arrStrings.get ( index ).length () - 1;
				
			}
			
			else if ( numIsPositive && newMaxLength ) {
				
				maxLength = arrStrings.get ( index ).length ();
				
			}
			
		}
		
	}
	
	static void addZeros () {
		
		for ( int index = 0; index < arrStrings.size(); ++ index ) {
			
			String pattern = "^([-]*)([^-]*)$";
			
			Pattern compiledPattern = Pattern.compile ( pattern );
			
			Matcher matcher = compiledPattern.matcher ( arrStrings.get ( index ) );
			
			boolean numIsNegative = arrStrings.get ( index ).indexOf ( '-' ) != -1;
			
			if ( numIsNegative ) {
				
				String numZeros = "0".repeat ( maxLength - arrStrings.get ( index ) .length () + 1 );
				
				String replacement = String.format ( "$1%s$2", numZeros );
				
				String replacedString = matcher.replaceAll ( replacement );
				
				arrStrings.set ( index, replacedString );
				
			}
			
			else {
				
				String numZeros = "0".repeat ( maxLength - arrStrings.get ( index ) .length () );
				
				String replacement = String.format ( "$1%s$2", numZeros );
				
				String replacedString = matcher.replaceAll ( replacement );
				
				arrStrings.set ( index, replacedString );
				
			}
			
		}
		
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
