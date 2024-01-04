import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

    public static void main ( String [] args ) {

        int[] nums = { 1, 1, 3 };

        System.out.println ( permutationsUnique ( nums ) );

    }

    static List<List<Integer>> permutationsUnique ( int[] nums ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> availableElements = toList(nums);

        return helper ( 0, new ArrayList<Integer>(), availableElements, nums, result );

    }

    static List<List<Integer>> helper ( int currentIndex, List<Integer> currentPermutation, List<Integer> availableElements, int[] nums, List<List<Integer>> result ) {

        if ( availableElements.size() == 0 ) {

            if ( !result.contains( currentPermutation ) ) {

                result.add ( new ArrayList<Integer>(currentPermutation) );

            }

            return result;

        }

        for ( int index = 0; index < availableElements.size(); ++ index ) {

            currentPermutation.add ( availableElements.get(index) );

            List<Integer> newRemainingElements = ignoreCurrentIndex(availableElements, index);

            helper ( currentIndex, currentPermutation, newRemainingElements, nums, result );

            currentPermutation.remove(currentPermutation.size() - 1);

        }

        return result;

    }

    static List<Integer> toList ( int[] nums ) {

        List<Integer> result = new ArrayList<Integer>();

        for ( int index = 0; index < nums.length; ++ index ) {

            result.add(nums[index]);

        }

        return result;

    }

    static List<Integer> ignoreCurrentIndex ( List<Integer> list, int indexToIgnore ) {

        List<Integer> firstHalf = list.subList(0, indexToIgnore);

        List<Integer> secondHalf = list.subList(indexToIgnore + 1, list.size());

        List<Integer> result = new ArrayList<Integer>(firstHalf);

        result.addAll(secondHalf);

        return result;

    }

}