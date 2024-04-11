import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main ( String [] args ) {

        Solution sl = new Solution();

        System.out.println ( sl.removeKdigits ( "1234567890", 9 ) );

    }

    public String removeKdigits ( String num, int k ) {

        if ( num.length() == k ) {

            return "0";

        }

        List<Integer> monotonicStack = this.gatherIndices ( num, k );

        String result =  this.buildOutput ( num, monotonicStack );

        return this.noLeadingZeros ( result );

    }

    public List<Integer> gatherIndices ( String string, int k ) {

        List<Integer> monotonicStack = new ArrayList<Integer>();

        int index = 0;

        int removed = 0;

        while ( removed < k && index < string.length() - 1 ) {

            if ( string.charAt ( index ) > string.charAt ( index + 1 ) ) {

                removed ++;

            }

            else {

                monotonicStack.add ( index );

            }

            index ++;

        }

        while ( index < string.length() ) {

            monotonicStack.add ( index ++ );

        }

        while ( removed < k ) {

            int place = index - 1 - removed;

            if ( string.charAt ( place ) != '0' )

            monotonicStack.remove ( place );

            removed ++;

        }



        return monotonicStack;

    }

    public String buildOutput ( String string, List<Integer> monotonicStack ) {

        StringBuilder sb = new StringBuilder();

        for ( int index: monotonicStack ) {

            sb.append ( string.charAt ( index ) );

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