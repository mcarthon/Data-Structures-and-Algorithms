package code;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		int[] nums = { 1, 2, 3}; 
		
		System.out.println ( nums.length * 2 );

		System.out.println ( Arrays.toString ( getConcatenation ( nums ) ) );

	}
	
	static int[] getConcatenation ( int[] nums ) {
		
		int[] ans = new int [ nums.length * 2 ];
		
		int iteration = 0;
		
		while ( iteration < nums.length * 2 ) {
			
			ans [ iteration ] = nums [ iteration % nums.length ];
			
			iteration ++;
			
		}
		
		return ans;
		
	}

}
