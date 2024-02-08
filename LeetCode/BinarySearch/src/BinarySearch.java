public class BinarySearch {

    public static void main ( String [] args ) {

        int[] nums = { -1, 0, 3, 5, 9, 12 };

        BinarySearch bs = new BinarySearch();

        bs.search ( nums, 6 );

    }

    public int answer = -1;

    public int search ( int[] nums, int target ) {

        this.helper ( nums, target, 0, nums.length - 1 );

        return this.answer;

    }

    public void helper ( int[] nums, int target, int start, int end ) {

        if ( start > end ) {

            return;

        }

        int mid = start + ( end - start ) / 2;

        int midNum = nums [ mid ];

        if ( midNum == target ) {

            this.answer = mid;

            return;

        }

        if ( midNum < target ) {

            this.helper ( nums, target, mid + 1, end );

        }

        if ( midNum > target ) {

            this.helper ( nums, target, start, mid - 1 );

        }

    }

}