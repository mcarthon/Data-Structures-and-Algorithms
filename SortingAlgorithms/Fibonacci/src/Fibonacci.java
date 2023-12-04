public class Fibonacci {

    static Integer find_fibonacci ( Integer n )     {

        if ( n == 0 || n == 1 ) {

            return n;

        }

        return find_fibonacci ( n - 1 );

    }

}
