package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverseII {

	public static void main(String[] args) {

		List<List<Integer>> nums = new ArrayList<>();
		
		int[] row1 = { 1, 2, 3, 4, 5 };
		
		List<Integer> Row1 = makeRow ( row1 );
		
		int[] row2 = { 6, 7 };
		
		List<Integer> Row2 = makeRow ( row2 );			
		
		int[] row3 = { 8 };
		
		List<Integer> Row3 = makeRow ( row3 );
		
		int[] row4 = { 9, 10, 11 };
		
		List<Integer> Row4 = makeRow ( row4 );
		
		int[] row5 = { 12, 13, 14, 15, 16 };
		
		List<Integer> Row5= makeRow ( row5 );
		
		nums.add ( Row1 );
		
		nums.add ( Row2 );
		
		nums.add ( Row3 );
		
		nums.add ( Row4 );
		
		nums.add ( Row5 );
		
		System.out.println ( nums );
		
		System.out.println ( Arrays.toString ( findDiagonalOrder ( nums ) ) );
		
		
		List<List<Integer>> nums1 = new ArrayList<>();
		
		int[] rows1 = { 14, 12, 19, 16, 9 };
		
		List<Integer> Rows1 = makeRow ( rows1 );
		
		int[] rows2 = { 13, 14, 15, 8, 11 };
		
		List<Integer> Rows2 = makeRow ( rows2 );			
		
		int[] rows3 = { 11, 13, 1 };
		
		List<Integer> Rows3 = makeRow ( rows3 );
		
		nums1.add ( Rows1 );
		
		nums1.add ( Rows2 );
		
		nums1.add ( Rows3 );
		
		System.out.println ( nums1 );
		
		System.out.println ( Arrays.toString ( findDiagonalOrder ( nums1 ) ) );

	}
	
	static int[] findDiagonalOrder ( List<List<Integer>> nums ) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for ( int row = 0; row < nums.size(); ++ row ) {
			
			int i = row;
			
			int j = 0;
			
			 while ( i > -1 ) {
				 
				 if ( j < nums.get( i ).size() ) {
					 
					 result.add( nums.get(i).get(j) );
					 
				 }				 
				 
				 i = i - 1;
				 
				 j = j + 1;
				 
			 }
			
		}		
		
		int maxCols = maxNumberOfColumns ( nums );
		
		for ( int column = 1; column < maxCols; ++ column ) {
		
			int i = nums.size() - 1;
			
			int j = column;
			
			while ( i > -1 ) {
				 
				 if ( j < nums.get( i ).size() ) {
					 
					 result.add( nums.get(i).get(j) );
					 
				 }				 
				 
				 i = i - 1;
				 
				 j = j + 1;
				 
			 }
			
		}
	
		return changeArrayListToArray( result );
		
	}
	
	static int countElements ( List<List<Integer>> nums ) {
		
		int count =  0;
		
		int row = 0;
		
		int column = 0;
		
		while ( row < nums.size() ) {
			
			if ( nums.get(row).get(column) == null ) {
				
				row ++;
				
				column = 0;
				
			}
			
			else {
				
				count ++;
				
				column ++;
				
				if ( column >= nums.get( row ).size() ) {
					
					column = 0;
					
					row ++;
					
				}
				
			}			
						
		}
		
		return count;
		
	}
	
	static int[] changeArrayListToArray ( ArrayList<Integer> array ) {
		
		int[] result = new int[array.size()];
		
		int index = 0;
		
		while ( index < array.size() ) {
			
			result[index] = array.get(index);
				
			index ++;
			
		}
		
		return result;
		
	}
	
	static List<Integer> makeRow ( int[] array ) {
		
		List<Integer> row = new ArrayList<Integer>();
		
		for ( int index = 0; index < array.length; ++ index ) {
			
			row.add( array[index] );
			
		}
		
		return row;
		
	}
	
	static int maxNumberOfColumns ( List<List<Integer>> nums ) {
		
		int maxCols = nums.get( 0 ).size();
		
		if ( nums.size() < 2 ) {
			
			return maxCols;
			
		}		
		
		for ( int row = 1; row < nums.size(); ++ row ) {
			
			int currentRowSize = nums.get( row ).size();
			
			if ( currentRowSize > maxCols ) {
				
				maxCols = currentRowSize;
				
			}
			
		}
		
		return maxCols;
		
	}

}
