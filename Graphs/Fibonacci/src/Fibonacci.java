public class Fibonacci {

    public static void main ( String [] args ) {

        System.out.println ( find_fibonacci ( 4 ) );

    }

    static int[] memo = { 0, 1 };

    static int find_fibonacci ( int n ) {

        if ( n < 2 ) {

            return n;

        }

        for ( int number = 2; number <= n; ++ number ) {

            int newFib = memo [ 0 ] + memo [ 1 ];

            swap ( memo );

            memo [ 1 ] = newFib;

        }

        return memo [ 1 ];

    }

    static void swap ( int[] array ) {

        int temp = array [ 0 ];

        array [ 0 ] = array [ 1 ];

        array [ 1 ] = temp;

    }


}