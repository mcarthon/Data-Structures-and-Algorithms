import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main ( String [] args ) {

        int [] numbers = { 0, 1, 2 };

        System.out.println ( subsets ( numbers ) );

    }


    static List<List<Integer>> subsets ( int [] numbers ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> currentSubset = new ArrayList<Integer>();

        return helper ( 0, currentSubset, result, numbers );

    }

    static List<List<Integer>> helper ( int currentIndex, List<Integer> currentSubset,
                                        List<List<Integer>> result, int [] numbers ) {

        if ( currentIndex > numbers.length - 1 ) {

            result.add ( new ArrayList<Integer>( currentSubset ) );

            return result;

        }

        helper ( currentIndex + 1, currentSubset, result, numbers );

        currentSubset.add ( numbers [ currentIndex ] );

        helper ( currentIndex + 1, currentSubset, result, numbers );

        currentSubset.remove ( currentSubset.size() - 1 );

        return result;

    }

}