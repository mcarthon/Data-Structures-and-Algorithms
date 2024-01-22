import java.util.LinkedList;

public class MaxConsecutiveOnesIII {

    public int maxLength = 0;

    public static void main ( String [] args ) {

        int [] nums = { 0, 0, 1, 1, 1, 0, 0 };

        MaxConsecutiveOnesIII mo3 = new MaxConsecutiveOnesIII();

        System.out.println ( mo3.longestOnes ( nums, 0 ) );

    }

    public int longestOnes ( int[] nums, int k ) {

        LinkedList<Integer> zeroIndexList = new LinkedList<Integer>();

        int start = 0;

        int end = start;

        if ( nums [ 0 ] == 0 ) {

            zeroIndexList.add ( 0 );

            if ( zeroIndexList.size() > k ) {

                start = zeroIndexList.getFirst() + 1;

                end = start;

                zeroIndexList.removeFirst();

            }

            else {

                end ++;

                this.maxLength ++;

            }

        }

        int length = nums.length;

        return this.helper ( start, end, zeroIndexList, nums, k, length );

    }

    public int helper ( int start, int end, LinkedList<Integer> zeroIndexList, int[] nums, int k, int length ) {

        if ( end == length ) {

            this.maxLength = Math.max ( this.maxLength, end - start );

            return this.maxLength;

        }

        if ( nums [ end ] == 0 ) {

            zeroIndexList.addLast ( end );

            if ( zeroIndexList.size() > k ) {

                this.maxLength = Math.max ( this.maxLength, end - start );

                start = zeroIndexList.getFirst() + 1;

                end = zeroIndexList.getLast();

                zeroIndexList.removeFirst();

            }

        }

        this.helper ( start, end + 1, zeroIndexList, nums, k, length );

        return this.maxLength;

    }

}