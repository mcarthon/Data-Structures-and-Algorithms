public class NchooseR {

    public static void main ( String [] args ) {

        System.out.println ( ncr ( 5, 3 ) );

    }

    static Integer ncr ( Integer n, Integer r ) {

        int modNumber = (int) Math.pow(10, 9) + 7;

        System.out.println ( modNumber );

        if ( r > n ) {
            
            return 0;
            
        }
        
        if ( r == n || r == 0 ) {
            
            return 1;
            
        }

        long[][] table = new long[n+1][r+1];

        for ( int row = 0; row < table.length; ++ row ) {

            table [ row ] [ 0 ] = 1;

        }

        for ( int index = 1; index < table[0].length; ++ index ) {

            table [ index ] [ index ] = 1;

        }

        for ( int row = 2; row < table.length; ++ row ) {

            for ( int column = 1; column < table[row].length; ++ column ) {

                table [ row ] [ column ] = (table [ row - 1 ] [ column - 1 ] + table [ row - 1 ] [ column ]) % modNumber;

            }

        }

        return (int) table[n][r];

    }

}