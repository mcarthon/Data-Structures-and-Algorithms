public class ReverseString {

    static void reverseString ( char[] s ) {

        for ( int index = 0; index < s.length; ++ index ) {

            swap ( s, index, s.length - index - 1 );

        }

    }

    static void swap ( char[] s, int left, int right ) {

        char temp = s [ left ];

        s [ left ] = s [ right ];

        s [ right ] = temp;

    }

}