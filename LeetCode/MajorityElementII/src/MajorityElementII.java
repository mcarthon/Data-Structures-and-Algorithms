import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MajorityElementII {

    public static void main ( String [] args ) {

        MajorityElementII me = new MajorityElementII();

        int[] nums = { 2, 2, 1, 3 };

        System.out.println ( me.majorityElement ( nums ) );

    }

    public List<Integer> majorityElement ( int[] nums ) {

        int threshhold = nums.length / 3;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for ( int index = 0; index < nums.length; ++ index ) {

            int key = nums [ index ];

            int value = map.getOrDefault ( key, 0 ) + 1;

            map.put ( key, value );

            if ( map.size() > 2 ) {

                this.trimMap ( map, threshhold );

            }

        }

        this.finalCheck ( nums, map, threshhold );

        return this.mapToList ( map );

    }

    public void finalCheck ( int[] nums, HashMap<Integer, Integer> map, int threshhold ) {

        Iterator<Integer> iterator = map.keySet().iterator();

        while ( iterator.hasNext() ) {

            Integer key = iterator.next();

            int count = 0;

            for ( int num: nums ) {

                if ( key.equals ( num ) ) {

                    count ++;

                }

            }

            if ( count <= threshhold ) {

                iterator.remove();

            }

        }

    }

    public void trimMap ( HashMap<Integer, Integer> map, int threshhold ) {

        Iterator<Integer> iterator = map.keySet().iterator();

        while ( iterator.hasNext() ) {

            Integer key = iterator.next();

            map.put ( key, map.get ( key ) - 1 );

            if ( map.get ( key ) < 1 ) {

                iterator.remove ();

            }

        }

    }

    public List<Integer> mapToList ( HashMap<Integer, Integer> map ) {

        List<Integer> result = new ArrayList<Integer>();

        for ( Integer key: map.keySet() ) {

            result.add ( key );

        }

        return result;

    }

}