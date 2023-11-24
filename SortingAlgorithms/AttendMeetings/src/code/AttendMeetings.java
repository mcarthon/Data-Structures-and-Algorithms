package code;

import java.util.ArrayList;
import java.util.Comparator;

public class AttendMeetings {

	public static void main ( String [] args ) {		
		

	}
	
	static Integer can_attend_all_meetings ( ArrayList<ArrayList<Integer>> intervals ) {
		
		sortIntervals( intervals );
		
		int meeting = 0;
		
		while ( meeting < intervals.size() - 1 ) {
			
			int endIndex = intervals.get ( meeting ).size() - 1;
			
			int endTime = intervals.get ( meeting ).get ( endIndex );
			
			int startTime = intervals.get ( meeting + 1 ).get ( 0 );
			
			if ( endTime > startTime ) {
				
				return 0;
				
			}
			
			meeting ++;
			
		}
		
		return 1;
		
	}
	
	public static class IntervalComparator implements Comparator < ArrayList<Integer> > {
		
		@Override
		public int compare ( ArrayList<Integer> interval1, ArrayList<Integer> interval2 ) {
			
			int startTimeComparison = Integer.compare ( interval1.get(0), interval2.get(0) );
			
			if ( startTimeComparison != 0 ) {
				
				return startTimeComparison;
				
			}
			
			else {
				
				int interval1End = interval1.size() - 1;
				
				int interval2End = interval2.size() - 1;
				
				int endTimeComparison = Integer.compare ( interval1.get( interval1End ), interval2.get( interval2End ) );
				
				return endTimeComparison;
				
			}
			
		}
		
	}
	
	static void sortIntervals ( ArrayList<ArrayList<Integer>> intervals ) {
		
		IntervalComparator comparator = new IntervalComparator();
		
		intervals.sort ( comparator );
		
	}

}
