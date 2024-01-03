import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    static List<String> fizzBuzz ( int n ) {

        List<String> result = new ArrayList<String>();

        for ( int index = 1; index <= n; ++ index ) {

            String string = "";

            if ( index % 3 == 0 ) {

                string += "Fizz";

            }

            if ( index % 5 == 0 ) {

                string += "Buzz";

            }

            if ( index % 3 != 0 && index % 5 != 0 ) {

                string += "" + index;

            }

            result.add(string);

        }

        return result;

    }

}