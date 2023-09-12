package code;

import java.util.ArrayList;
import java.util.Random;

public class Implementation {
	
	public static void main (String[] args ) {

	    ArrayList<Integer> testArray = new ArrayList<Integer> ();

	    testArray.add(5);
	    testArray.add(8);
	    testArray.add(3);
	    testArray.add(9);
	    testArray.add(4);
	    testArray.add(1);
	    testArray.add(7);

	    quick_sort(testArray);
	    
	    System.out.println ( testArray );

	    }
	
	static void quick_sort ( ArrayList<Integer> arr ) {
		
		helper ( arr, 0, arr.size () - 1 );
		
	}
	
	static void helper ( ArrayList<Integer> arr, int start, int end ) {
		
		if ( start < end ) {
			
			int[] pivotIndices = hoaresPartition ( arr, start, end );
			
			helper ( arr, start, pivotIndices[0] );
			
			helper ( arr, pivotIndices[1], end );
			
		}
		
	}
	
	 static int[] hoaresPartition ( ArrayList<Integer> arr, int start, int end ) {	        	     
	        
	        Random random = new Random();
	        
	        int pivotIndex = random.nextInt ( end - start + 1 ) + start;	        	      
	        
	        int leftPointer = start;
	        
	        int runner = start;
	        
	        int rightPointer = end;
	        
	        while ( runner <= rightPointer ) {	        		   
	            
	            if ( arr.get ( runner ) < arr.get ( pivotIndex ) ) {
	            	
	            	swap ( arr, leftPointer, runner );
	            	
	            	leftPointer ++;
	            	
	            	runner ++;
	            	
	            }
	            
	            else if ( arr.get ( runner ) > arr.get ( pivotIndex ) ) {
	            	
	            	swap ( arr, rightPointer, runner );
	            	
	            	rightPointer --;
	            	
	            }
	            
	            else {
	            	
	            	runner ++;
	            	
	            }

	    }
	        
	        return new int[] { rightPointer, runner };
	        
	 }
	    
	    static void swap (ArrayList<Integer> arr, int left, int right) {
	        
	        int temp = arr.get ( left );
	        
	        arr.set ( left, arr.get ( right ) );
	        
	        arr.set ( right, temp );
	        
	    }

}
