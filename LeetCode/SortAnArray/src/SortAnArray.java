import java.util.Arrays;

public class SortAnArray {

    public static void main ( String [] args ) {

        int [] nums = { 6, 4, -7, 4, 8, 10, 2, -4 };

        System.out.println ( Arrays.toString (mergeSort ( nums ) ) );

    }

    static int [] mergeSort ( int [] nums ) {

        if ( nums.length < 2 ) {

            return nums;

        }

        int [] firstHalf = Arrays.copyOfRange ( nums, 0, nums.length / 2 );

        int [] secondHalf = Arrays.copyOfRange ( nums, nums.length / 2, nums.length );

        firstHalf = mergeSort ( firstHalf );

        secondHalf = mergeSort ( secondHalf );

        return merge ( firstHalf, secondHalf );

    }

    static int [] merge ( int [] firstHalf, int [] secondHalf ) {

        int first = 0;

        int second = 0;

        int [] aux = new int [ firstHalf.length + secondHalf.length ];

        int index = 0;

        while ( first < firstHalf.length && second < secondHalf.length ) {

            if ( firstHalf [ first ] <= secondHalf [ second ] ) {

                aux [ index ] = firstHalf [ first ];

                index ++;

                first ++;

            }

            else {

                aux [ index ] = secondHalf [ second ];

                index ++;

                second ++;

            }

        }

        while ( first < firstHalf.length ) {

            aux [ index ] = firstHalf [ first ];

            index ++;

            first ++;

        }

        while ( second < secondHalf.length ) {

            aux [ index ] = secondHalf [ second ];

            index ++;

            second ++;

        }

        return aux;

    }

}