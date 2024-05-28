public class Solution {

    public static void main ( String [] args ) {

        int[] nums = { 1,3,2,3,3 };

        Solution s = new Solution();

        System.out.println ( s.countSubarrays ( nums, 2 ) );

    }

    public long countSubarrays ( int[] nums, int k ) {

        int start = 0;
        int end = 0;
        int length = nums.length;
        int max = this.findMax ( nums, length );
        int maxNumberCount = 0;
        boolean expandWindow = false;
        long subArrayCount = 0;

        while ( end < length ) {

            int currentNumber = nums [ end ];

            // we have now found the start of the window
            if ( currentNumber == max && !expandWindow && maxNumberCount == 0 ) {

                maxNumberCount ++;

                expandWindow = true;

                start = end;

            }

            // expanding window
            else if ( currentNumber == max && expandWindow && maxNumberCount < k ) {

                maxNumberCount ++;

                if ( maxNumberCount == k ) {

                    expandWindow = false;

                    subArrayCount ++;

                }

            }

            // window size is set and we need to shift window
            else if ( !expandWindow && maxNumberCount == k ) {

                while ( nums [ start ] != max ) {

                    start ++;

                    subArrayCount ++;

                }

                subArrayCount ++;

            }

            end ++;

        }

        while ( start < end )

        return subArrayCount;

    }

    public int findMax ( int[] nums, int length ) {

        int max = nums [ 0 ];

        for ( int num: nums ) {

            max = Math.max ( num, max );

        }

        return max;

    }

}