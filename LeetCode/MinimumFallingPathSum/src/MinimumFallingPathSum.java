public class MinimumFallingPathSum {

    public int minSum = 301;

    public static void main ( String [] args ) {

        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum ();

        System.out.println ( minimumFallingPathSum.minFallingPathSum ( matrix ) );

    }

    public int minFallingPathSum ( int[][] matrix ) {

        int length = matrix.length;

        int minColumnIndex = 0;

        for ( int column = 0; column < length; ++ column ) {

            if ( matrix[0][column] < matrix[0][minColumnIndex] ) {

                minColumnIndex = column;

            }

        }

        this.helper ( matrix, 0, 0, minColumnIndex, length );

        return this.minSum;

    }

    public int helper ( int[][] matrix, int currentSum, int row, int column, int length ) {

        if ( row == length || column == length || row < 0 || column < 0 ) {

            return this.minSum;

        }

        int newCurrentSum = currentSum + matrix[row][column];

        if ( row == length - 1 && newCurrentSum < this.minSum ) {

            this.minSum = newCurrentSum;

            return this.minSum;

        }

        this.helper ( matrix, newCurrentSum, row + 1, column - 1, length );

        this.helper ( matrix, newCurrentSum, row + 1, column, length );

        this.helper ( matrix, newCurrentSum, row + 1, column + 1, length );

        return this.minSum;

    }

}