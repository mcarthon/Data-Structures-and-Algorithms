import java.util.ArrayList;

public class NChooseK {

    public static void main ( String [] args ) {

        System.out.println ( find_combinations ( 4, 2 ) );

    }

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();

    static ArrayList<ArrayList<Integer>> find_combinations ( int n, int k ) {

        ArrayList<Integer> partial = new ArrayList<Integer>();

        nChooseKCombinations ( n, k, 1, partial );

        return result;

    }

    static void nChooseKCombinations ( int n, int k, int subproblemIndex, ArrayList<Integer> partialSolution ) {

        if ( partialSolution.size () == k ) {

            result.add ( partialSolution );

            return;

        }

        if ( subproblemIndex > n ) {

            return;

        }

        // exclude
        nChooseKCombinations ( n, k, ++ subproblemIndex, partialSolution );

        // include

        partialSolution.add ( subproblemIndex );

        nChooseKCombinations ( n, k, ++ subproblemIndex, partialSolution );

        partialSolution.remove ( partialSolution.size() - 1 );

    }

}