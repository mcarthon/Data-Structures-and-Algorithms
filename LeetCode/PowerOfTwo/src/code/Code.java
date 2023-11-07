package code;

public class Code {

	public static void main( String[] args ) {

		System.out.println ( isPowerOfTwo ( 16 ) );

	}
	
	static boolean isPowerOfTwo(int n) {
        
	    if ( n == 1 ) {

	            return true;

	    }

	    while ( n >= 2 ) {	       

	        if ( n % 2 != 0 ) {

	            return false;

	        }
	        
	        n = n / 2;

	    }

	    return true;

	}

}
