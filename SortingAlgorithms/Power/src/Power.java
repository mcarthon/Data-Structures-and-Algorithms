public class Power {

    public static void main ( String [] args ) {

        Long a = (long) 123;

        Long b = (long) 123;

        System.out.println ( calculate_power ( a, b ) );

    }

    static Integer calculate_power ( Long a, Long b ) {

        if ( b == 0 ) {

            return 1;

        }

        int aInt = (int) (a % 1000000007);

        if ( a < 2 ) {

            return aInt;

        }

        return ( aInt * calculate_power ( a, b - 1 ) ) % 1000000007;

    }

}