public class LongestPalindromeSting {
    public static void main ( String [] args ) {

        String string = "aacabdkacaa";

        System.out.println ( longestPalindrome ( string ) );

    }

    static String longestPalindrome ( String string ) {

        String result = "";
        int resultLength = 0;

//        Treat each character in the string as the nucleus of a palindrome
        for (int index = 0; index < string.length(); ++index) {

            //odd length palindrome
            int left = index;
            int right = index;

            while ( left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right) ) {

                if ( string.substring(left, right + 1).length() > resultLength ) {

                    result = string.substring(left, right + 1);
                    resultLength = string.substring(left, right + 1).length();

                }

                left --;
                right ++;

            }

            //even length palindrome
            left = index;
            right = left + 1;

            while ( left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right) ) {

                if ( string.substring(left, right + 1).length() > resultLength ) {

                    result = string.substring(left, right + 1);
                    resultLength = string.substring(left, right + 1).length();

                }

                left --;
                right ++;

            }

        }

        return result;

    }

}