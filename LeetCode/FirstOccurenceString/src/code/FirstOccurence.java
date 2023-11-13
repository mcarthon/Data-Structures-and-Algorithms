package code;

public class FirstOccurence {

	public static void main ( String[] args ) {
		
		System.out.println ( strStr ( "mississippi", "issip" ) );
		
		System.out.println ( strStr ( "mississippi", "pi" ) );			

	}
	
	static public int strStr ( String haystack, String needle ) {
		
		if ( haystack == needle ) {
			
			return 0;
			
		}
        
		int haystackPointer = 0;
		
		int needlePointer = 0;
		
		int firstOccurenceIndex = -1;
		
		int lastMatch = -1;
		
		while ( haystackPointer < haystack.length () && needlePointer < needle.length () ) {
			
			if ( haystack.charAt ( haystackPointer ) == needle.charAt( needlePointer ) ) {
				
				if ( firstOccurenceIndex == -1 ) {
					
					firstOccurenceIndex = haystackPointer;					
					
				}
				
				lastMatch = haystackPointer;
								
				needlePointer ++;
				
				haystackPointer ++;
				
			}
			
			else {
				
				firstOccurenceIndex = -1;
					
				if ( ( haystack.charAt( haystackPointer ) != haystack.charAt( haystackPointer + 1 ) ) && needlePointer != 0 ) {
					
					haystackPointer = lastMatch;
					
					needlePointer = 0;
					
					continue;
					
				}
				
				haystackPointer ++;
				
			}
			
		}
		
		if ( needlePointer < needle.length () ) {
			
			return -1;
			
		}
		
		return firstOccurenceIndex;
		
    }

}
