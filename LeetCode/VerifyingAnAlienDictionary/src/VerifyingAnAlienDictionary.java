import java.util.HashMap;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted ( String[] words, String order ) {

        HashMap<Character, Integer> map = this.createMap ( order );

        for ( int i = 0; i < words.length - 1; ++ i ) {

            String word1 = words [ i ];

            String word2 = words [ i + 1 ];

            boolean checkLength = false;

            int length = Math.min ( word1.length(), word2.length() );

            for ( int j = 0; j < length; ++ j ) {

                char word1Letter = word1.charAt ( j );

                char word2Letter = word2.charAt ( j );

                int word1Value = map.get ( word1Letter );

                int word2Value = map.get ( word2Letter );

                if ( word1Value < word2Value ) {

                    checkLength = false;

                    break;

                }

                else if ( word1Value == word2Value ) {

                    checkLength = true;

                }

                else {

                    return false;

                }

            }

            if ( checkLength && word1.length() > word2.length() ) {

                return false;

            }

        }

        return true;

    }

    public HashMap<Character, Integer> createMap ( String order ) {

        HashMap<Character, Integer> result = new HashMap<Character, Integer>();

        for ( int index = 0; index < order.length(); ++ index ) {

            result.put ( order.charAt ( index ), index );

        }

        return result;

    }

}