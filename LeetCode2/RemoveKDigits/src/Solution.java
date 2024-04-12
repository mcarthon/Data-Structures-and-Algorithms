import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main ( String [] args ) {

        Solution sl = new Solution();

        System.out.println ( sl.removeKdigits ( "112", 1 ) );

    }

    public String removeKdigits ( String num, int k ) {

        if ( num.length() == k ) {

            return "0";

        }

        int [] included = new int [ 10 ];

        List<Character> monotonicStack = this.gatherIndices ( num, k, included );

        String result =  this.buildOutput ( num, monotonicStack );

        return this.noLeadingZeros ( result );

    }

    public List<Character> gatherIndices ( String string, int k, int [] included ) {

        List<Character> monotonicStack = new ArrayList<Character>();

        int index = 0;

        int removed = 0;

        while ( removed < k && index < string.length() - 1 ) {

            int number = Integer.parseInt ( String.valueOf ( string.charAt ( index ) ) );

            if ( string.charAt ( index ) > string.charAt ( index + 1 ) ) {

                removed ++;

            }

            else {

                monotonicStack.add ( string.charAt ( index ) );

                included [ number ] ++;

            }

            index ++;

        }

        while ( index < string.length() ) {

            monotonicStack.add ( string.charAt ( index ) );

            int number = Integer.parseInt ( String.valueOf ( string.charAt ( index ) ) );

            included [ number ] ++;

            index ++;

        }

        while ( index > 0 && removed < k ) {

            int place = index - 1;

            int number = Integer.parseInt ( String.valueOf ( string.charAt ( place ) ) );

            char character = string.charAt ( place );

            if ( character != '0' && included [ number ] > 0 ) {

                monotonicStack.remove ( Character.valueOf ( character ) );

                included [ number ] --;

                removed ++;

            }

            index --;

        }



        return monotonicStack;

    }

    public String buildOutput ( String string, List<Character> monotonicStack ) {

        StringBuilder sb = new StringBuilder();

        for ( char character: monotonicStack ) {

            sb.append ( character );

        }

        return sb.toString();

    }

    public String noLeadingZeros ( String string ) {

        int start = 0;

        while ( start < string.length() - 1 && string.charAt ( start ) == '0' ) {

            start ++;

        }

        return string.substring ( start );

    }

}