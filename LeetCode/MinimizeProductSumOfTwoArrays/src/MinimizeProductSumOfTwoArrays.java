import java.util.HashMap;

public class MinimizeProductSumOfTwoArrays {

    public int minProductSum ( int[] nums1, int[] nums2 ) {

        int length = nums1.length;

        int[] nums1Sort = this.countingSort ( nums1, length );

        int[] nums2SortReverse = this.countingSortReverse ( nums2, length );

        int product1 = this.dotProduct ( nums1Sort, nums2SortReverse, length );

//        int[] nums1SortReverse = this.countingSortReverse ( nums1, length );
//
//        int[] nums2Sort = this.countingSort ( nums2, length );
//
//        int product2 = this.dotProduct ( nums1SortReverse, nums2Sort, length );
//
//        return Math.min ( product1, product2 );

        return product1;

    }

    public int dotProduct ( int[] nums1, int[] nums2, int length ) {

        int sum = 0;

        for ( int index = 0; index < length; ++ index ) {

            int product = nums1 [ index ] * nums2 [ index ];

            sum += product;

        }

        return sum;

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

    public int[] countingSortReverse ( int [] nums, int length ) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for ( int index = 0; index < length; ++ index ) {

            int key = nums [ index ];

            map.put ( key, map.getOrDefault ( key, 0 ) + 1 );

        }

        int [] result = new int [ length ];

        int resultIndex = 0;

        for ( int index = 100; index > -1; -- index ) {

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