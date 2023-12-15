import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main ( String [] args ) {

        System.out.println ( combinations ( 4, 2 ) );

    }

    static List<List<Integer>> combinations ( int n, int k ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> currentCombination = new ArrayList<Integer>();

        return helper ( n, k, currentCombination, result, 1 );

    }

    static List<List<Integer>> helper ( int n, int k, List<Integer> currentCombination, List<List<Integer>> result, int currentNumber ) {

        if ( currentCombination.size() == k ) {

            result.add ( new ArrayList<Integer>( currentCombination ) );

            return result;

        }

        if ( currentNumber > n ) {

            return result;

        }

        currentCombination.add ( currentNumber );

        helper ( n, k, currentCombination, result, currentNumber + 1 );

        currentCombination.remove ( currentCombination.size() - 1 );

        helper ( n, k, currentCombination, result, currentNumber + 1 );

        return result;

    }

}