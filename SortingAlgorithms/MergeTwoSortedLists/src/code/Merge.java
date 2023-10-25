package code;

import java.util.ArrayList;

public class Merge {

	public static void main(String[] args) {

		ArrayList<Integer> array1 = new ArrayList<Integer>();
		
		array1.add ( 1 );
		
		array1.add ( 3 );
		
		array1.add ( 5 );
		
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		
		array2.add ( 2 );
		
		array2.add ( 4 );
		
		array2.add ( 6 );
		
		array2.add ( 0 );
		
		array2.add ( 0 );
		
		array2.add ( 0 );
		
		System.out.println ( merge ( array1, array2 ) );

	}
	
	static ArrayList<Integer> merge ( ArrayList<Integer> array1, ArrayList<Integer> array2 ) {
		
		int left = array1.size () - 1;
		
		int right = array1.size () - 1;
		
		int index = array2.size () - 1;
		
		while ( right > -1 && left > -1 ) {
			
			Integer array1Val = array1.get ( left );
			
			Integer array2Val = array2.get ( right );
			
			Integer indexVal = array2.get ( index );
			
			if ( array1Val >= array2Val ) {
				
				Integer temp = indexVal;
				
				array2.set ( index, array1Val );
				
				array1.set ( left, temp );
				
				left --;
				
				index --;
				
			}
			
			else {
				
				Integer temp = indexVal;
				
				array2.set ( index, array2Val );
				
				array2.set ( right, temp );
				
				right --;
				
				index --;
				
			}
			
		}
		
		if ( left < 0 ) {
			
			while ( index > -1 ) {
				
				Integer temp = array2.get ( index );
				
				array2.set ( index, array2.get ( right ) );
				
				array2.set ( right, temp );
				
				right --;
				
				index --;
				
			}
			
		}
		
		if ( right < 0 ) {
			
			while ( index > -1 ) {
				
				Integer temp = array2.get ( index );
				
				array2.set ( index, array1.get ( left ) );
				
				array1.set ( left, temp );
				
				left --;
				
				index --;
				
			}
			
		}
		
		return array2;
		
	}
	
}
