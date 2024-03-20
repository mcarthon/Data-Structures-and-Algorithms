public class BinaryGap {

    public static void main ( String [] args ) {

        BinaryGap bg = new BinaryGap();

        System.out.println ( bg.binaryGap ( 17 ) );

    }

    public int binaryGap ( int n ) {

        String binaryRep = this.binaryTransform ( n );

        System.out.println ( binaryRep );

        return this.calculateGap ( binaryRep );

    }

    public String binaryTransform ( int n ) {

        StringBuilder result = new StringBuilder();
        boolean foundOne = false;

        for ( int i = 1 << 30; i > 0; i = i >> 1 ) {

            if ( (n & i) != 0 ) {

                result.append ( "1" );

                foundOne = true;

            }

            else if ( foundOne ) {

                result.append ( "0" );

            }

        }

        return result.toString();

    }

    public int calculateGap ( String binaryNum ) {

        int left = 0;
        int right = 1;
        int currentLength = 0;
        int maxLength = 0;

        while ( right < binaryNum.length() ) {

            if ( binaryNum.charAt ( left ) == '1' && binaryNum.charAt ( right ) == '0' ) {

                while ( right < binaryNum.length() && binaryNum.charAt ( right ) != '1' ) {

                    right ++;

                }

                if ( right < binaryNum.length() && binaryNum.charAt ( right ) == '1' ) {

                    currentLength = right - left - 1;

                    maxLength = Math.max ( maxLength, currentLength );

                    currentLength = 0;

                    left = right;

                    right = left + 1;

                }

            }

            else {

                left ++ ; right ++;

            }

        }

        return maxLength;

    }

}