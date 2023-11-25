package code;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingChars {

	public static void main ( String [] args ) {

		String string = "abcabcbb";
		
		System.out.println ( lengthOfLongestSubstring ( string ) );
		
		String string2 = "bbbbb";
		
		System.out.println ( lengthOfLongestSubstring ( string2 ) );
		
		String string3 = "pwwkew";
		
		System.out.println ( lengthOfLongestSubstring ( string3 ) );
		
		String string4 = "au";
		
		System.out.println ( lengthOfLongestSubstring ( string4 ) );

	}
	
	static int lengthOfLongestSubstring ( String string ) {
		
		if ( string.length() < 2 ) {
			
			return string.length();
			
		}
		
		int left = 0;
		
		int right = 1;
		
		int maxSize = 1;
		
		ArrayList<Character> currentChars = new ArrayList<Character>();
		
		currentChars.add ( string.charAt ( left ) );
		
		while ( right < string.length() ) {
			
			if ( !currentChars.contains ( string.charAt ( right ) ) ) {
				
				currentChars.add ( string.charAt ( right ++ ) );
				
			}
			
			else {
				
				int currentLength = currentChars.size();
				
				if ( currentLength > maxSize ) {
					
					maxSize = currentLength;
					
				}
				
				currentChars.clear();
				
				left ++;
				
				if ( left < string.length() ) {
					
					currentChars.add ( string.charAt ( left ) );
					
					right = left + 1;
					
				}
				
				else {
					
					break;
					
				}
				
			}					
			
		}
		
		int currentLength = currentChars.size();
		
		if ( currentLength > maxSize ) {
			
			return currentLength;
			
		}
		
		return maxSize;
		
	}

}
