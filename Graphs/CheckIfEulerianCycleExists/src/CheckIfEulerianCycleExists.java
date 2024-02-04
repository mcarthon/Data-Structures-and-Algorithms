import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CheckIfEulerianCycleExists {

    static Boolean check_if_eulerian_cycle_exists ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for ( ArrayList<Integer> innerArray : edges ) {

            Integer key = innerArray.get ( 0 );

            Integer value = map.getOrDefault ( key, 0 ) + 1;

            map.put ( key, value );

            Integer key1 = innerArray.get ( 1 );

            Integer value1 = map.getOrDefault ( key1, 0 ) + 1;

            map.put ( key1, value1 );

        }

        Collection<Integer> values = map.values();

        for ( Integer value : values ) {

            if ( value % 2 != 0 ) {

                return false;

            }

        }

        return true;

    }

}