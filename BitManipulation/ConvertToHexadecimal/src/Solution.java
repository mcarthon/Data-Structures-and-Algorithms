import java.util.HashMap;

public class Solution {

    public static void main ( String [] args ) {

        Solution sl = new Solution();

        System.out.println ( sl.toHex ( -1 ) );

    }

    public String toHex ( int num ) {

        int number = num < 0 ? ~num + 1 : num;

        String binaryRep = this.convertToBinary ( number );

        return this.convertToHexadecimal ( binaryRep );

    }

    public String convertToBinary ( int num ) {

        int power = this.findHighestPowerOfTwo ( num );

        return this.binaryRepresentation ( num, power );

    }

    public int findHighestPowerOfTwo ( int num ) {

        int power = 0;

        while ( Math.pow ( 2, power ) < num ) {

            power ++;

        }

        return Math.pow ( 2, power ) > num ? power - 1 : power;

    }

    public String binaryRepresentation ( int num, int power ) {

        int remaining = num;

        StringBuilder result = new StringBuilder();

        while ( remaining > 0 || power > -1 ) {

            int currentNumber = (int) Math.pow ( 2, power );

            if ( currentNumber <= remaining ) {

                String nextDigit = String.format ( "%d", remaining / currentNumber );

                result.append ( nextDigit );

                remaining -= currentNumber * ( remaining / currentNumber );

            }

            else {

                result.append ( "0" );

            }

            power --;

        }

        return result.toString();

    }

    public String convertToHexadecimal ( String input ) {

        StringBuilder hexadecimal = new StringBuilder();

        HashMap<Integer, String> hexMap = new HashMap<Integer, String>();

        hexMap.put ( 10, "a" );
        hexMap.put ( 11, "b" );
        hexMap.put ( 12, "c" );
        hexMap.put ( 13, "d" );
        hexMap.put ( 14, "e" );
        hexMap.put ( 15, "f" );

        for ( int right = input.length(); right > -1 ; right -= 4 ) {

            //1000101010
            //length = 10
            //[6,10)
            //next -> [2, 6)
            // [0, 2)

            int left = Math.max ( right - 4, 0 );

            int nextNum = this.currentFour ( input.substring ( left, right ) );

            String nextCharacter = nextNum < 10 ? String.format ( "%d", nextNum ) : hexMap.get ( nextNum );

            hexadecimal.insert ( 0, nextCharacter );

        }

        return hexadecimal.toString();

    }

    public int currentFour ( String input ) {

        int power = 0;

        int result = 0;

        for ( int index = input.length() - 1; index > -1 ; -- index ) {

            int currentPower = (int) Math.pow ( 2, power );

            int currentDigit = Integer.parseInt ( String.valueOf( input.charAt ( index ) ) );

            int currentNumber =  currentDigit * currentPower;

            result += currentNumber;

            power ++;

        }

        return result;

    }

}