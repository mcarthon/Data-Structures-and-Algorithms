import java.util.ArrayList;

public class MaxPathSum {

    static Integer maximum_path_sum ( ArrayList<ArrayList<Integer>> grid ) {

        int numberOfRows = grid.size();
        int numberOfColumns = grid.get ( 0 ).size();

        int[][] table = new int [ numberOfRows ] [ numberOfColumns ];

        table[0][0] = grid.get(0).get(0);

        for ( int row = 1; row < numberOfRows; ++ row ) {

            table [ row ] [ 0 ] = grid.get ( row ).get(0) + table [ row - 1 ] [ 0 ];

        }

        for ( int column = 1; column < numberOfColumns; ++ column ) {

            table [0] [ column ] = grid.get(0).get ( column ) + table [ 0 ] [ column - 1 ];

        }

        for ( int row = 1; row < numberOfRows; ++ row ) {

            for ( int column = 1; column < numberOfColumns; ++ column ) {

                int max = Math.max ( table [ row - 1 ] [ column ], table [ row ] [ column - 1 ] );

                table [ row ] [ column ] = grid.get ( row ).get ( column ) + max;

            }

        }

        return table [ numberOfRows - 1 ] [ numberOfColumns - 1 ];

    }

}