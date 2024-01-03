public class MatrixDiagonalSum {

    static int diagonalSum ( int[][] mat ) {

        int primaryDiagonalSum = 0;

        for ( int i = 0; i < mat.length; ++ i ) {

            primaryDiagonalSum += mat[i][i];

        }

        int secondaryDiagonalSum = 0;

        for ( int j = 0; j < mat.length; ++ j ) {

            secondaryDiagonalSum += mat[j][mat.length - 1 - j];

        }

        if ( mat.length % 2 != 0 ) {

            secondaryDiagonalSum -= mat[mat.length/2][mat.length/2];

        }

        return primaryDiagonalSum + secondaryDiagonalSum;

    }

}