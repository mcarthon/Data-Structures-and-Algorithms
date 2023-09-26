package code;

import java.util.ArrayList;

public class RadixSort {
	
	static ArrayList<String> arrStrings = new ArrayList<String>();
	
	static int maxLength = 0;

	public static void main( String[] args ) {
		
		

	}
	
	static void stringifyAndMaxLength ( ArrayList<Integer> arr ) {
		
		for ( int index = 0; index < arr.size (); ++ index ) {
			
			arrStrings.add ( String.valueOf ( arr.get ( index ) ) );
			
			if ( arrStrings.get ( index ).length() > maxLength ) {
				
				maxLength = arrStrings.get ( index ).length();
				
			}
			
		}
		
	}
	
	static void addZeros () {
		
		for ( int index = 0; index < arrStrings.size(); ++ index ) {
			
			arrStrings.set ( index, "0".repeat ( maxLength - arrStrings.get ( index ) .length () ) + arrStrings.get ( index ) );
			
		}
		
	}
	
//	static void 

}
