public class MaxConsecutiveOnesII {

    public int maxLength = 1;

    public static void main ( String [] args ) {

        int[] nums = { 1, 0, 1, 1, 0, 1 };

        MaxConsecutiveOnesII mco = new MaxConsecutiveOnesII();

        System.out.println ( mco.findMaxConsecutiveOnes ( nums ) );

    }

    public int findMaxConsecutiveOnes ( int[] nums ) {

        int length = nums.length;

        int numZeroes = 0;

        int lastZeroIndex = -1;

        if ( nums [ 0 ] == 0 ) {

            numZeroes ++;

            lastZeroIndex ++;

        }

        return this.helper ( 0, 1, numZeroes, lastZeroIndex, length, nums );

    }

    public int helper ( int start, int end, int numZeros, int lastZeroIndex, int length, int[] nums ) {

        if ( end == length ) {

            this.maxLength = Math.max ( end - start, maxLength );

            return this.maxLength;

        }

        if ( nums [ end ] == 0 ) {

            numZeros ++;

            if ( numZeros > 1 ) {

                this.maxLength = Math.max ( end - start, maxLength );

                start = lastZeroIndex + 1;

                numZeros --;

            }

            lastZeroIndex = end;

        }

        this.maxLength = Math.max ( end - start, maxLength );

        this.helper ( start, end + 1, numZeros, lastZeroIndex, length, nums );

        return this.maxLength;

    }

}