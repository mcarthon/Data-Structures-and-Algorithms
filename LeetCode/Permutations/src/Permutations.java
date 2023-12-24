import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main ( String [] args ) {

        int[] nums = {1,2,3};

        System.out.println( permute(nums) );

    }

    static List<List<Integer>> permute ( int[] nums ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        ArrayList<Integer> currentPermutation = new ArrayList<Integer>();

        return helper ( currentPermutation, nums, result );

    }

    static List<List<Integer>> helper ( ArrayList<Integer> currentPermutation, int[] remainingElements, List<List<Integer>> result ) {

        if ( remainingElements.length < 1 ) {

            result.add ( new ArrayList<Integer> ( currentPermutation ) );

            return result;

        }

        for ( int index = 0; index < remainingElements.length; ++ index ) {

            currentPermutation.add ( remainingElements [ index ] );

            int [] elementsLeftOver = excludeCurrentIndex ( remainingElements, index );

            helper ( currentPermutation, elementsLeftOver, result );

            currentPermutation.remove ( currentPermutation.size() - 1 );

        }

        return result;

    }

    static int[] excludeCurrentIndex ( int[] array, int indexToExclude ) {

        int [] result = new int [ array.length - 1 ];

        int resultIndex = 0;

        for ( int index = 0; index < array.length; ++ index ) {

            if ( index == indexToExclude ) {

                continue;

            }

            result [ resultIndex ++ ] = array[ index ];

        }

        return result;

    }

}