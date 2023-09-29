package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.*;

public class RadixSort {
	
	static ArrayList<String> arrStrings = new ArrayList<String>();
	
	static int maxLength = 0;
	
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
	
	static HashMap<Character, Integer> setMap () {
		
		HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		
		for ( char integer = '0'; integer <= '9'; ++ integer ) {
			
			frequencyMap.put ( integer, 0 );
			
		}
		
		return frequencyMap;
		
	}
	
	static HashMap<Character, Integer> findCounts ( HashMap<Character, Integer> frequencyMap, ArrayList<Character> arr ) {
		
		for ( char integer : arr ) {
			
			frequencyMap.put ( integer, frequencyMap.get ( integer ) + 1 );
			
		}
		
		return frequencyMap;
		
	}
	
	static ArrayList<Character> getCharLists ( int index, ArrayList<String> strings ) {
		
		ArrayList<Character> result = new ArrayList<Character>();
		
		for ( String string: strings ) {
			
			result.add ( string.charAt ( index ) );						
			
		}
		
		return result;
		
	}
	
	static ArrayList<Character> countsortChars ( ArrayList<Character> chars, 
			
												 HashMap<Character, Integer> frequencyMap ) {
		
		ArrayList<Character> result = new ArrayList<Character>();
		
		for ( char digit = '0'; digit <= 9; ++ digit ) {
			
			if ( frequencyMap.get ( digit ) > 0 ) {
				
				result.addAll ( Collections.nCopies ( frequencyMap.get ( digit ), digit ) );
				
			}
			
		}
		
		return result;
		
	}
	
	static void sortStrings () {
		
		for ( int index = 0; index < maxLength; ++ index ) {
			
			ArrayList<Character> chars = getCharLists ( index, arrStrings );
			
			HashMap<Character, Integer> frequencyMap = setMap ();
			
			frequencyMap = findCounts ( frequencyMap, chars );
			
			ArrayList<Character> sortedChars = countsortChars ( chars, frequencyMap );
			
		}
		
	}
		
}