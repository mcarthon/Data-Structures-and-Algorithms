import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main ( String [] args ) {

        String digits = "234";

        System.out.println( letterCombinations( digits ) );

    }

    static List<String> letterCombinations ( String digits ) {

        List<String> result = new ArrayList<String>();

        if ( digits.length() < 1 ) {

            return result;

        }

        HashMap<Character, String> digitsMap = new HashMap<Character, String>();

        digitsMap.put ( '2', "abc" );
        digitsMap.put ( '3', "def" );
        digitsMap.put ( '4', "ghi" );
        digitsMap.put ( '5', "jkl" );
        digitsMap.put ( '6', "mno" );
        digitsMap.put ( '7', "pqrs" );
        digitsMap.put ( '8', "tuv" );
        digitsMap.put ( '9', "wxyz" );

        return helper ( 0, 0, "", digitsMap, digits, result );

    }

    static List<String> helper ( int currentDigitsIndex, int currentMapIndex, String currentCombination, HashMap<Character, String> digitsMap, String originalString, List<String> result ) {

        if ( currentDigitsIndex == originalString.length() ) {

            result.add ( currentCombination );

            return result;

        }

        String bagOfLetters = digitsMap.get(originalString.charAt(currentDigitsIndex));

        if ( currentMapIndex == bagOfLetters.length() ) {

            return result;

        }

        currentCombination += bagOfLetters.charAt ( currentMapIndex );

        helper ( currentDigitsIndex + 1, 0, currentCombination, digitsMap, originalString, result );

        String newCombination = currentCombination.substring ( 0, currentCombination.length() - 1 );

        helper ( currentDigitsIndex, currentMapIndex + 1, newCombination, digitsMap, originalString, result );

        return result;

    }

}