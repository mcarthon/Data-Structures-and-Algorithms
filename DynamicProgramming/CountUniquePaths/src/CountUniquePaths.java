public class CountUniquePaths {

    static Integer unique_paths ( Integer n, Integer m ) {

        int[][] table = new int [n][m];

        int mod = ( int ) Math.pow ( 10, 9 ) + 7;

        for ( int row = 0; row < n; ++ row ) {

            table [ row ] [ 0 ] = 1;

        }

        for ( int column = 0; column < m; ++ column ) {

            table [ 0 ] [ column ] = 1;

        }

        for ( int row = 1; row < n; ++ row ) {

            for ( int column = 1; column < m; ++ column ) {

                table [ row ] [ column ] = ( table [ row - 1 ] [ column ] + table [ row ] [ column - 1 ] ) % mod;

            }

        }

        return table [ n - 1 ] [ m - 1 ];

    }

}