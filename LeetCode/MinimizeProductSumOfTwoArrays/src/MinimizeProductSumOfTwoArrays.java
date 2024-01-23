import java.util.HashMap;

public class MinimizeProductSumOfTwoArrays {

    public int minProductSum ( int[] nums1, int[] nums2 ) {

        int length = nums1.length;

    }

    public int[] countingSort ( int [] nums, int length ) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for ( int index = 0; index < length; ++ index ) {

            int key = nums [ index ];

            map.put ( key, map.getOrDefault ( key, 0 ) + 1 );

        }

        int [] result = new int [ length ];

        int resultIndex = 0;

        for ( int index = 0; index < 101; ++ index ) {

            if ( map.containsKey ( index ) ) {

                int frequency = map.get ( index );

                while ( frequency > 0 ) {

                    result [ resultIndex ++ ] = index;

                    frequency --;

                }

            }

        }

        return result;

    }


}