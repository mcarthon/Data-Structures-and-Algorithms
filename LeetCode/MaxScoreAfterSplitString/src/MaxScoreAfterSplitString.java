public class MaxScoreAfterSplitString {

    public static void main ( String [] args ) {

        System.out.println( maxScoreAfterSplit ( "011101" ) );

    }

    static int maxScoreAfterSplit ( String string ) {

        int maxScore = 0;
        int leftSideZeros = 0;
        int rightSideOnes = 0;

//        initial scan for number of ones in initial split
        for ( int index = 0; index < string.length(); ++ index ) {

            if ( string.charAt(index) == '1' ) {

                rightSideOnes ++;

            }

        }

        for ( int index = 0; index < string.length() - 1; ++ index ) {

            if ( string.charAt (index) == '0' ) {

                leftSideZeros ++;

            }

            else {

                rightSideOnes --;

            }

            int currentScore = leftSideZeros + rightSideOnes;

            if ( currentScore > maxScore ) {

                maxScore = currentScore;

            }

        }

        return maxScore;

    }

}