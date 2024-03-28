import java.util.HashMap;

public class LongestSubsequenceWithatMostKFreq {

    public static void main ( String [] args ) {

        int[] nums = { 1,2,3,1,2,3,1,2 };

        LongestSubsequenceWithatMostKFreq l = new LongestSubsequenceWithatMostKFreq();

        System.out.println ( l.maxSubarrayLength ( nums, 2 ) );

        int[] nums2 = { 1,2,1,2,1,2,1,2 };

        System.out.println ( l.maxSubarrayLength ( nums2, 1 ) );

    }

    public int maxSubarrayLength ( int[] nums, int k ) {

        if ( nums.length == 1 ) {

            return 1;

        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int start = 0;
        int end = 0;
        int longestWindowSize = 1;

        while ( end < nums.length ) {

            int currentNumber = nums [ end ];

            if ( map.get ( currentNumber ) == null ) {

                map.put ( currentNumber, 1 );

            }

            else if ( map.get ( currentNumber ) <= k ) {

                int currentFrequency = map.get ( currentNumber );

                map.put ( currentNumber, currentFrequency + 1 );

            }

            if ( map.get ( currentNumber ) > k ) {

                if ( nums [ start ] == currentNumber ) {

                    start ++;

                    int currentFrequency = map.get ( currentNumber );

                    map.put ( currentNumber, currentFrequency - 1 );

                }

                else {

                    while ( nums [ start ] != currentNumber ) {

                        int currentFrequency = map.get ( nums [ start ] );

                        map.put ( nums [ start ++ ], currentFrequency - 1 );

                    }

                    int currentFrequency = map.get ( nums [ start ] );

                    map.put ( nums [ start ++ ], currentFrequency - 1 );

                }

            }

            longestWindowSize = Math.max ( longestWindowSize, end - start + 1 );

            end ++;

        }

        return longestWindowSize;

    }

}