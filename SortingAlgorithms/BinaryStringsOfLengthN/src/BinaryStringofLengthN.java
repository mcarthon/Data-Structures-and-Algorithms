import java.util.ArrayList;

public class BinaryStringofLengthN {

    public static void main ( String [] args ) {

        System.out.println ( get_binary_strings ( 3 ) );

    }

    static ArrayList<String> get_binary_strings ( Integer n ) {

        ArrayList<String> result = new ArrayList<String>();

        String slate = "";

        return binaryStrings ( n, slate, result );

    }

    static ArrayList<String> binaryStrings ( int n, String slate, ArrayList<String> result ) {

        if ( n == 0 ) {

            result.add ( slate );

            return result;

        }

        binaryStrings ( n - 1, slate.concat ( "0" ), result );

        binaryStrings ( n - 1, slate.concat ( "1" ), result );

        return result;

    }

}