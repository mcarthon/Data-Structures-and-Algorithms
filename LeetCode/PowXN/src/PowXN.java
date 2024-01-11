public class PowXN {

    public static void main ( String[] args ) {

        PowXN pow = new PowXN();

        System.out.println ( pow.myPow( 10, -1 ) );

    }

    public double myPow ( double x, int n ) {

        if ( n == 0 ) {

            return 1.0;

        }

        return n > 0 ? helper ( x, n ) : 1.0 / helper ( x, -1 * (long) n );

    }

    public double helper ( double x, long n ) {

        if ( n == 1 ) {

            return x;

        }

        double half = helper ( x, n/2 );

        return n % 2 == 0 ? half * half : x * half * half;

    }

}
