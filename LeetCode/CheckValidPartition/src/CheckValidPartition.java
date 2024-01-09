import java.util.HashMap;

public class CheckValidPartition {

    boolean result = false;

    boolean validPartition ( int[] nums ) {

        HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

        return this.helper ( 0, nums, memo );

    }

    boolean helper ( int currentIndex, int[] values, HashMap<Integer, Boolean> memo ) {

        if ( memo.containsKey ( currentIndex ) ) {

            result = memo.get ( currentIndex );

            return result;

        }

        if ( currentIndex == values.length ) {

            return true;

        }

        result = false;

        if ( currentIndex < values.length - 1 && values[currentIndex] == values[currentIndex + 1] ) {

            result = helper ( currentIndex + 2, values, memo );

        }

        if ( currentIndex < values.length - 2 ) {

            if ( (values[currentIndex] == values[currentIndex + 1] && values[currentIndex + 1] == values[currentIndex + 2])
                  || (values[currentIndex + 2] == values[currentIndex + 1] + 1 && values[currentIndex + 1] == values[currentIndex] + 1) ) {

                result = result || helper ( currentIndex + 3, values, memo );

            }

        }

        memo.put(currentIndex, result);

        return result;

    }

}