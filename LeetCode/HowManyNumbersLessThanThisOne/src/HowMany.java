import java.util.Arrays;

public class HowMany {

    public static void main ( String [] args ) {

        int [] nums = { 8, 1, 2, 2, 3 };

        System.out.println ( Arrays.toString ( smallerNumbersThanCurrent ( nums ) ) );

    }

    static int[] smallerNumbersThanCurrent ( int [] nums ) {

        int [] buckets = new int [ 101 ];

        for ( int index = 0; index < nums.length; ++ index ) {

            buckets [ nums [ index ] ] ++;

        }

        for ( int index = 1; index < buckets.length; ++ index ) {

            buckets [ index ] += buckets [ index - 1 ];

        }

        for ( int index = 0; index < nums.length; ++ index ) {

            nums [ index ] = nums [ index ] == 0 ? 0 : buckets [ nums [ index ] - 1 ];

        }

        return nums;

    }

}
