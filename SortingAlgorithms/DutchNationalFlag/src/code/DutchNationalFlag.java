package code;

import java.util.ArrayList;

public class DutchNationalFlag {

	public static void main( String[] args ) {

		ArrayList<Character> arr = new ArrayList<Character>();
		
		arr.add ( 'G' );
		
		arr.add ( 'B' );
		
		arr.add ( 'G' );
		
		arr.add ( 'G' );
		
		arr.add ( 'R' );
		
		arr.add ( 'B' );
		
		arr.add ( 'R' );
		
		arr.add ( 'G' );
		
		System.out.println ( arr );
		
		System.out.println ( partition ( arr ) );

	}
	
	static ArrayList<Character> partition ( ArrayList<Character> arr ) {
		
		int lowPointer = 0;
		
		int midPointer = 0;
		
		int highPointer = arr.size() - 1;
		
		while ( !( midPointer > highPointer ) ) {
			
			if ( arr.get ( midPointer ) == 'B' ) {
				
				swap ( arr, midPointer, highPointer );
				
				highPointer --;
				
			}
			
			else if ( arr.get ( midPointer ) == 'R' ) {
				
				swap ( arr, midPointer, lowPointer );
				
				lowPointer ++;
				
				midPointer ++;
				
			}
			
			else {
				
				midPointer ++;
				
			}
			
			System.out.println ( arr );
			
		}
		
		return arr;
		
	}
	
	static void swap ( ArrayList<Character> arr, int left, int right ) {
		
		Character temp = arr.get ( left );
		
		arr.set ( left, arr.get ( right ) );
		
		arr.set ( right, temp );
		
	}

}
