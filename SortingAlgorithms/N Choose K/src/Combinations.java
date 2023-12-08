import java.util.ArrayList;

public class Combinations {

    public static void main(String[] args) {

        int n1 = 1;

        int k1 = 1;

        System.out.println(findCombinations(n1, k1));

        int n2 = 6;

        int k2 = 6;

        System.out.println(findCombinations(n2, k2));
    }

    // Function to find all combinations of k numbers in the range from 1 to n
    static ArrayList<ArrayList<Integer>> findCombinations(int n, int k) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> currentCombination = new ArrayList<>();

        // Start the recursive process with the first number (1)
        findCombinationsHelper(n, k, 1, currentCombination, result);

        return result;

    }

    // Recursive helper function to generate combinations
    static void findCombinationsHelper(int n, int k, int start, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> result) {

        // Base case: If k becomes 0, add the current combination to the result
        if (k == 0) {

            result.add(new ArrayList<>(currentCombination));

            return;

        }

        // Iterate over the numbers from 'start' to 'n'
        for (int i = start; i <= n; i++) {

            // Include the current number in the combination
            currentCombination.add(i);

            // Recursively find combinations with k-1 numbers starting from the next number
            findCombinationsHelper(n, k - 1, i + 1, currentCombination, result);

            // Backtrack by removing the last added number for the next iteration
            currentCombination.remove(currentCombination.size() - 1);

        }

    }

}