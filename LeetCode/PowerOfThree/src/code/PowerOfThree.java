package code;

public class PowerOfThree {

	public static void main(String[] args) {

		System.out.println ( isPowerOfThree ( 0 ) );
		
		System.out.println ( isPowerOfThree ( -2 ) );
		
		System.out.println ( isPowerOfThree ( 81 ) );
		
		System.out.println ( isPowerOfThree ( 3 ) );

	}
	
	static boolean isPowerOfThree(int n) {

        if ( n < 1 ) {

            return false;

        }

        if ( n == 1 ) {

            return true;

        }

        while ( n >= 2 ) {

            if ( n % 3 != 0 ) {

                return false;

            }

            n = n / 3;

        }

        return true;
        
    }
	
}
