import java.util.ArrayList;

public class Combinations {

    public static void main(String[] args) {

        int n1 = 5;

        int k1 = 2;

        System.out.println(findCombinations(n1, k1));

        int n2 = 6;

        int k2 = 6;

        System.out.println(findCombinations(n2, k2));
    }

    // Function to find all combinations of k numbers in the range from 1 to n
    static ArrayList<ArrayList<Integer>> findCombinations ( int n, int k ) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> currentCombination = new ArrayList<Integer>();

        combinationsRecursive ( 1, n, k, currentCombination, result );

        return result;

    }

    static void combinationsRecursive ( int currentNumber, int n, int k, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> result ) {

        if ( currentCombination.size () == k ) {

            result.add ( new ArrayList<Integer>( currentCombination ) );

            return;

        }

        if ( currentNumber > n ) {

            return;

        }

        currentCombination.add ( currentNumber );

        combinationsRecursive ( currentNumber + 1, n, k, currentCombination, result );

        currentCombination.remove ( currentCombination.size() - 1 );

        combinationsRecursive ( currentNumber + 1, n, k, currentCombination, result );

    }

}