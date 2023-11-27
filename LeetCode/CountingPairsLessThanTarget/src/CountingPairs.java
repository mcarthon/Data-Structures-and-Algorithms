import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingPairs {

    public static void main ( String [] args ) {

        List<Integer> nums = new ArrayList<Integer>();

        nums.add( -6 );
        nums.add( 2 );
        nums.add( 5 );
        nums.add( -2 );
        nums.add( -7 );
        nums.add( -1 );
        nums.add( 3 );

        System.out.println ( countPairs ( nums, -2 ) );

    }

    static int countPairs (List<Integer> nums, int target ) {

        int count  = 0;

        int i = 0;

        int j = nums.size() - 1;

        Collections.sort ( nums );

        while ( i < j ) {

            if ( nums.get( i ) + nums.get ( j ) < target ) {

                count += j - i;

                i ++;

            }

            else {

                j --;

            }

        }

        return count;

    }

}