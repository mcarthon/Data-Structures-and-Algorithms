public class MajorityElement {

    public static void main ( String [] args ) {

        int [] nums = { 10, 9, 9, 9, 10 };

        System.out.println ( majorityElement ( nums ) );

    }

    static int majorityElement ( int [] nums ) {

        int count = 0;

        int majorityElement = nums [ 0 ];

        for ( int index = 0; index < nums.length; ++ index ) {

            if ( nums [ index ] == majorityElement ) {

                count ++;

            }

            else {

                count --;

            }

            if ( count < 0 ) {

                majorityElement = nums [ index ];

                count = 0;

            }

        }

        return majorityElement;

    }

}