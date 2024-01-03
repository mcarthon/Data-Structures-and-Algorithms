import java.util.HashSet;

public class ContainsDuplicatesII {

    public static void main ( String [] args ) {

        int[] nums = { 1, 0, 1, 1 };

        System.out.println ( containsNearbyDuplicate ( nums, 1 ) );

    }

    static boolean containsNearbyDuplicate ( int[] nums, int k ) {

        HashSet<Integer> visitedNumbers = new HashSet<Integer>();

        for ( int index = 0; index <= k && index < nums.length; ++ index ) {

            if ( !visitedNumbers.add ( nums[index] ) ) {

                return true;

            }

        }

        for ( int index = k + 1; index < nums.length; ++ index ) {

            int indexToRemove = index - ( k + 1 );

            visitedNumbers.remove ( nums[indexToRemove] );

            if ( !visitedNumbers.add ( nums[index] ) ) {

                return true;

            }

        }

        return false;

    }

}