import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CheckIfEulerianPathExists {

    static Boolean check_if_eulerian_path_exists ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for ( ArrayList<Integer> edge : edges ) {

            Integer firstKey = edge.get ( 0 );

            Integer firstValue = frequencyMap.getOrDefault ( firstKey, 0 ) + 1;

            frequencyMap.put ( firstKey, firstValue );

            Integer secondKey = edge.get ( 1 );

            Integer secondValue = frequencyMap.getOrDefault ( secondKey, 0 ) + 1;

            frequencyMap.put ( secondKey, secondValue );

        }

        Collection<Integer> frequencies = frequencyMap.values();

        int oddFrequencyCount = 0;

        for ( Integer frequency : frequencies ) {

            if ( frequency % 2 != 0 ) {

                oddFrequencyCount ++;

            }

            if ( oddFrequencyCount > 2 ) {

                return false;

            }

        }

        return oddFrequencyCount != 1;

    }

}