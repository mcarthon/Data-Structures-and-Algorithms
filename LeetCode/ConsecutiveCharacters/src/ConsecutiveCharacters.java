public class ConsecutiveCharacters {

    public static void main ( String [] args ) {

        String string = "leetcode";
        String string2 = "eee";
        String string3 = "ccbccbb";

        System.out.println ( maxPower(string) );
        System.out.println ( maxPower(string2) );
        System.out.println ( maxPower(string3) );

    }

    static int maxPower ( String string ) {

        int maxLength = 1;
        int currentCount = 1;

        for ( int index = 0; index < string.length() - 1; ++ index ) {

            if ( string.charAt(index + 1) == string.charAt(index) ){

                currentCount ++;

            }

            else {

                if ( currentCount> maxLength ) {

                    maxLength = currentCount;

                }

                currentCount = 1;

            }

        }

        if (maxLength < currentCount ) {
            maxLength = currentCount;
        }
        return maxLength;
    }

}