package code;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OnlineStream {

	public static void main ( String [] args ) {

		ArrayList<Integer> stream = new ArrayList<Integer>();
		
		stream.add( 3 );
		stream.add( 8 );
		stream.add( 5 );
		stream.add( 2 );
		
		System.out.println ( online_median ( stream ) );

	}
	
	static ArrayList<Integer> online_median ( ArrayList<Integer> stream ) {
		
		ArrayList<Integer> medianStream = new ArrayList<Integer>();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (a, b) -> Integer.compare ( b, a ) );
		
		for ( int number: stream ) {
			
			addNumber ( number, minHeap, maxHeap );
			
			rebalanceHeaps ( minHeap, maxHeap );
			
			int median = calculateMedian ( minHeap, maxHeap );
			
			medianStream.add ( median );
			
		}
					
		return medianStream;
		
	}
	
	static void addNumber ( int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {
		
		if ( maxHeap.isEmpty() || number <= maxHeap.peek () ) {
			
			maxHeap.offer ( number );
			
		}
		
		else {
			
			minHeap.offer ( number );
			
		}
		
	}
	
	static void rebalanceHeaps ( PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {
		
		while ( maxHeap.size() > minHeap.size() + 1 ) {
			
			minHeap.offer ( maxHeap.poll() );
			
		}
		
		while ( minHeap.size() > maxHeap.size() ) {
			
			maxHeap.offer( minHeap.poll () );
			
		}
		
	}
	
	static int calculateMedian ( PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {
		
		if ( maxHeap.size() == minHeap.size() ) {
			
			return (int) Math.floor ( ( maxHeap.peek() + minHeap.peek() ) / 2 );
			
		}
		
		else {
			
			return maxHeap.peek();
			
		}
		
	}

}
