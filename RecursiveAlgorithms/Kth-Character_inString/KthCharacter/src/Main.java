//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main ( String[] args ) {

        Main main = new Main ();

        System.out.println ( main.kthCharacter ( 2 ) );

    }

    public char kthCharacter ( int k ) {

        StringBuilder word = new StringBuilder ( "a" );

        while ( word.length() < k ) {

            StringBuilder charactersToAppend = this.appendIncrementalCharacters ( String.valueOf ( word ) );

            word.append ( charactersToAppend );

        }

        return word.charAt ( k - 1 );

    }

    public StringBuilder appendIncrementalCharacters ( String word ) {

        StringBuilder result = new StringBuilder ();

        for ( int index = 0; index < word.length(); ++ index ) {

            char currentCharacter = word.charAt ( index );

            char nextChar = currentCharacter == 'z' ? 'a' : ( char ) ( currentCharacter + 1 );

            result.append ( nextChar );

        }

        return result;

    }

}