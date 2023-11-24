package code;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestInStream {

	public static void main ( String [] args ) {
		
		int k = 2;
		
		ArrayList<Integer> initial_stream = new ArrayList<Integer>();
		
		ArrayList<Integer> append_stream = new ArrayList<Integer>();
		
		initial_stream.add ( 4 );
		initial_stream.add ( 6 );
		
		append_stream.add ( 5 );
		append_stream.add ( 2 );
		append_stream.add ( 20 );
		
		System.out.println ( kth_largest ( k, initial_stream, append_stream ) );

	}
	
	static ArrayList<Integer> kth_largest ( Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream ) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (a, b) -> Integer.compare ( b, a ) );
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		ArrayList<Integer> resultStream = new ArrayList<Integer>();
		
		for ( int number: initial_stream ) {
			
			addNumber ( number, minHeap, maxHeap );
			
		}
		
		for ( int number: append_stream ) {
			
			addNumber ( number, minHeap, maxHeap );
			
			rebalanceHeaps ( k, minHeap, maxHeap );
			
			resultStream.add ( minHeap.peek () );
			
		}
		
		return resultStream;
		
	}
	
	static void addNumber ( int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {
		
		if ( minHeap.isEmpty() || number >= minHeap.peek () ) {
			
			minHeap.offer ( number );
			
		}
		
		else {
			
			maxHeap.offer ( number );
			
		}
		
	}
	
	static void rebalanceHeaps ( int k, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {
		
		while ( minHeap.size() < k ) {
			
			minHeap.offer( maxHeap.poll () );
			
		}
		
		while ( minHeap.size() > k ) {
			
			maxHeap.offer ( minHeap.poll() );
			
		}				
		
	}

}