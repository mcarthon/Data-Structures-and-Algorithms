import java.util.Comparator;

import java.util.PriorityQueue;

import java.util.Arrays;

public class SubsequenceOfLengthKWithLargestSum {

    public static void main ( String [] args ) {

        int [] nums = {-16,-13,8,16,35,-17,30,-8,34,-2,-29,-35,15,13,-30,-34,6,15,28,-23,34,28,-24,15,-17,10,31,32,-3,-36,19,31,-5,-21,-33,-18,-23,-37,-15,12,-28,-40,1,38,38,-38,33,-35,-28,-40,4,-15,-29,-33,-18,-9,-29,20,1,36,-8,23,-34,16,-7,13,39,38,7,-7,-10,30,9,26,27,-37,-18,-25,14,-36,23,28,-15,35,-9,1};

        System.out.println ( Arrays.toString ( maxSubsequence ( nums, 8 ) ) );

    }

    static int [] maxSubsequence ( int [] nums, int k ) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>( Comparator.comparingInt ( index -> nums [ index ] ) );

        for ( int index = 0; index < nums.length; ++ index ) {

            minHeap.offer ( index );

            if ( minHeap.size() > k ) {

                minHeap.poll();

            }

        }

        return minHeap.stream().sorted().mapToInt( i -> nums [ i ] ).toArray();

    }

}