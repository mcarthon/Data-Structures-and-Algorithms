package code;

public class PowerOfFour {

	public static void main(String[] args) {

		System.out.println ( isPowerOfThree ( 0 ) );
		
		System.out.println ( isPowerOfThree ( -2 ) );
		
		System.out.println ( isPowerOfThree ( 64 ) );
		
		System.out.println ( isPowerOfThree ( 4 ) );

	}
	
	static boolean isPowerOfThree ( int n ) {
  
        if ( n < 1 ) {

            return false;

        }

        if ( n == 1 ) {

            return true;

        }

        while ( n >= 2 ) {

            if ( n % 4 != 0 ) {

                return false;

            }

            n = n / 4;

        }

        return true;
        
    }

}
