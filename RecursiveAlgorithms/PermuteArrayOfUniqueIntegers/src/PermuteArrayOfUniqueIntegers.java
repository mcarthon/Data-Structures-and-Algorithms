import java.util.ArrayList;
import java.util.List;

public class PermuteArrayOfUniqueIntegers {

    public static void main ( String [] args ) {

        ArrayList<Integer> array = new ArrayList<Integer>();

        for ( int number = 0; number < 3; ++ number ) {

            array.add ( number );

        }

        System.out.println ( get_permutations ( array ) );

    }

    static ArrayList<ArrayList<Integer>> get_permutations ( ArrayList<Integer> array ) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> slate = new ArrayList<Integer>();

        return helper ( slate, array, result );

    }

    static ArrayList<ArrayList<Integer>> helper ( ArrayList<Integer> slate, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result ) {

        if ( array.size() < 1 ) {

            result.add ( new ArrayList<Integer>( slate ) );

            return result;

        }

        for ( int index = 0; index < array.size(); ++ index  ) {

            slate.add ( array.get ( index ) );

            List<Integer> firstHalf = array.subList ( 0, index );

            List<Integer> secondHalf = array.subList ( index + 1, array.size() );

            ArrayList<Integer> remainingElements = new ArrayList<Integer>( firstHalf );

            remainingElements.addAll ( secondHalf );

            helper ( slate, remainingElements, result );

            slate.remove ( slate.size() - 1 );

        }

        return result;

    }

}