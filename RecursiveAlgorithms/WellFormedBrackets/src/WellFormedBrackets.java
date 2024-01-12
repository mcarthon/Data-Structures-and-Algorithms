import java.util.ArrayList;

public class WellFormedBrackets {

    static ArrayList<String> brackets ( int n ) {

        return helper ( n, n, "", new ArrayList<String>() );

    }

    static ArrayList<String> helper ( int left, int right, String currentString, ArrayList<String> result ) {

        if ( left == 0 && right == 0 ) {

            result.add ( currentString );

            return result;

        }

        if ( left > 0 ) {

            helper ( left - 1, right, currentString + "(", result );

        }

        if ( right > 0 && left < right ) {

            helper ( left, right - 1, currentString + ")", result );

        }

        return result;

    }

}