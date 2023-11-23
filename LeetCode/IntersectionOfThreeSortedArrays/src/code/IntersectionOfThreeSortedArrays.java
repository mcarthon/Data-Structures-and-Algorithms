package code;

import java.util.ArrayList;

public class IntersectionOfThreeSortedArrays {

	public static void main ( String [] args ) {

		

	}
	

    static ArrayList<Integer> find_intersection ( ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3 ) {
        
        ArrayList<Integer> finalIntersection = new ArrayList<Integer>();
		
		boolean anyArrayIsEmpty = arr1.size() < 1 || arr2.size() < 1 || arr3.size() < 1;
		
		if ( anyArrayIsEmpty ) {
			
			finalIntersection.add( -1 );
			
			return finalIntersection;
			
		}
		
		int first = 0;
		
		int second = 0;
		
		ArrayList<Integer> oneTwoIntersection = new ArrayList<Integer>();
		
		while ( first < arr1.size() && second < arr2.size() ) {
			
			boolean oneLessThanTwo = arr1.get( first ) < arr2.get( second );
			
			boolean twoLessThanOne = arr2.get( second ) < arr1.get( first );
			
			if ( oneLessThanTwo ) {
				
				first ++;
				
			}
			
			else if ( twoLessThanOne ) {
				
				second ++;
				
			}
			
			else {
				
				oneTwoIntersection.add( arr1.get( first ) );
				
				first ++;
				
				second ++;
				
			}
			
		}				
		
		first = 0;
		
		second = 0;
		
		while ( first < oneTwoIntersection.size() && second < arr3.size() ) {
			
			boolean oneLessThanTwo = oneTwoIntersection.get( first ) < arr3.get( second );
			
			boolean twoLessThanOne = arr3.get( second ) < oneTwoIntersection.get( first );
			
			if ( oneLessThanTwo ) {
				
				first ++;
				
			}
			
			else if ( twoLessThanOne ) {
				
				second ++;
				
			}
			
			else {
				
				finalIntersection.add( oneTwoIntersection.get( first ) );
				
				first ++;
				
				second ++;
				
			}
			
		}
		
		if ( finalIntersection.size() < 1 ) {
		    
	        finalIntersection.add( -1 );	    
		    
		}
		
		return finalIntersection;
		
	}

}