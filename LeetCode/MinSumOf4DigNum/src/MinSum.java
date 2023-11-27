import java.util.Arrays;

public class MinSum {

    public static void main ( String [] args ) {

        System.out.println ( minimumSum ( 7342 ) );

    }

    static int minimumSum ( int number ) {

        int [] digits = new int [ 4 ];

        int index = 0;

        while ( index < digits.length ) {

            digits [ index ++ ] = number % 10;

            number /= 10;

        }

        Arrays.sort ( digits );

        int num1 = digits [ 0 ] * 10 + digits [ 3 ];

        int num2 = digits [ 1 ] * 10 + digits [ 2 ];

        return num1 + num2;

    }

}
