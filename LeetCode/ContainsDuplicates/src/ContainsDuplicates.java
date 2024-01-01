import java.util.HashSet;

public class ContainsDuplicates {

    static boolean containsDuplicates ( int [] nums ) {

        HashSet<Integer> visitedNumbers = new HashSet<Integer>();

        for ( int num: nums ) {

            if ( visitedNumbers.contains ( num ) ) {

                return true;

            }

            visitedNumbers.add ( num );

        }

        return false;

    }

}