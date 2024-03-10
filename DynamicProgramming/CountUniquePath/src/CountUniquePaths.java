public class CountUniquePaths {

    public int uniquePaths ( int m, int n ) {

        int[][] table = new int [m][n];

        for ( int column = 0; column < table[0].length; ++ column ) {

            table [ 0 ] [ column ] = 1;

        }

        for ( int row = 0; row < table.length; ++ row ) {

            table [ row ] [ 0 ] = 1;

        }

        for ( int row = 1; row < table.length; ++ row ) {

            for ( int column = 1; column < table[0].length; ++ column ) {

                table [ row ] [ column ] = table [ row - 1 ] [ column ] + table [ row ] [ column - 1 ];

            }

        }

        return table [ m - 1 ] [ n - 1 ];

    }

}