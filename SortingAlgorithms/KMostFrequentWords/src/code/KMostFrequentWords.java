package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KMostFrequentWords {

	public static void main ( String[] args ) {

		int k = 4;
		
		String[] wordsList = { "car", "bus", "taxi", "car", "driver", "candy", "race", "car", "driver", "fare", "taxi" };
		
		ArrayList<String> words = new ArrayList<String>( Arrays.asList ( wordsList ) );
		
		System.out.println ( words );
		
		System.out.println ( kMostFreq ( setFrequencyMap ( words ), words, k ) );
		
	}
	
	static HashMap< String, Integer > setFrequencyMap ( ArrayList<String> words ) {
		
		HashMap< String, Integer > frequencyMap = new HashMap< String, Integer>();
		
		for ( String word: words ) {
			
			frequencyMap.put ( word, 
					
							   frequencyMap.getOrDefault ( word, 0 ) + 1 );
			
		}
		
		return frequencyMap;
		
	}
	
	
	static List<String> kMostFreq ( HashMap<String, Integer> map, ArrayList<String> words, int k ) {
		
		Set<String> uniqueWords = new HashSet<>(words);
		
		List<String> uniqueWordsList = new ArrayList<>(uniqueWords);
		
		uniqueWordsList.sort ( Comparator.comparingInt ( map::get ).reversed() );
		
		uniqueWordsList = uniqueWordsList.subList ( 0, Math.min ( k, uniqueWordsList.size() ) );
		
		ArrayList<String> result = new ArrayList<String>(uniqueWordsList);
		
		return result;
		
	}

}