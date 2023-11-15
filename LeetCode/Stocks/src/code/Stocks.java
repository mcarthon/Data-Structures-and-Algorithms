package code;

public class Stocks {

	public static void main ( String [] args ) {

		int [] prices = { 2, 1, 2, 1, 0, 1, 2 };
		
		System.out.println ( maxProfit ( prices ) );

	}
	
	static int maxProfit ( int [] prices ) {
		
		if ( prices.length < 2 ) {
			
			return 0;
			
		}
		
		int maxProfit = 0;
		
		int buyPointer = 0;
		
		int sellPointer = 1;
		
		while ( sellPointer < prices.length ) {						
			
			if ( prices [ buyPointer ] < prices [ sellPointer ] ) {
				
				int profit = prices [ sellPointer ] - prices [ buyPointer ];
				
				if ( profit > maxProfit ) {
					
					maxProfit = profit;
					
				}
				
			}
			
			else {
				
				buyPointer = sellPointer;
				
			}
			
			sellPointer ++;
			
		}
		
		return maxProfit;
		
	}
	
}
