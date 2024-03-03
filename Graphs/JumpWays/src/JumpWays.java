public class JumpWays {

    static Long jump_ways ( Integer n ) {

        long[] memo = { 1, 2 };

        if ( n < 3 ) {

            return (Long) memo [ n - 1 ];

        }

        for ( int step = 3; step <= n; ++ step ) {

            long numWays = memo [ 0 ] + memo [ 1 ];

            swap ( memo );

            memo [ 1 ] = numWays;

        }

        return (Long) memo [ 1 ];

    }

    static void swap ( long[] array ) {

        long temp = array [ 0 ];

        array [ 0 ] = array [ 1 ];

        array [ 1 ] = temp;

    }

}