import java.util.HashMap;

public class MinNumOfKeypresses {

    public HashMap<Character, Integer> oneKeyPress = new HashMap<Character, Integer>();

    public HashMap<Character, Integer> twoKeyPresses = new HashMap<Character, Integer>();

    public HashMap<Character, Integer> threeKeyPresses = new HashMap<Character, Integer>();

    public static void main ( String [] args ) {

        MinNumOfKeypresses minKeypress = new MinNumOfKeypresses();

        System.out.println ( minKeypress.minimumKeypresses ( "aaaaaaaabcdefgggghijkllllllllllmmmnoppponono" ) );

    }

    public int minimumKeypresses ( String string ) {

        int length = string.length();

        this.createMaps ( string, length );

        return this.sumValues ( this.oneKeyPress ) + 2 * this.sumValues ( this.twoKeyPresses ) + 3 * this.sumValues ( threeKeyPresses );

    }

    public void createMaps ( String string, int length ) {

        for ( int index = 0; index < length; ++ index ) {

            Character currentCharacter = string.charAt ( index );

            if ( this.oneKeyPress.size() < 9 || oneKeyPress.containsKey ( currentCharacter ) ) {

                oneKeyPress.put ( currentCharacter, oneKeyPress.getOrDefault ( currentCharacter, 0 ) + 1 );

            }

            else if ( this.twoKeyPresses.size() < 9 || twoKeyPresses.containsKey ( currentCharacter ) ) {

                twoKeyPresses.put ( currentCharacter, twoKeyPresses.getOrDefault ( currentCharacter, 0 ) + 1 );

            }

            else {

                threeKeyPresses.put ( currentCharacter, threeKeyPresses.getOrDefault ( currentCharacter, 0 ) + 1 );

            }

        }

    }

    public int sumValues ( HashMap<Character, Integer> map ) {

        int sum = 0;

        for ( int num: map.values() ) {

            sum += num;

        }

        return sum;

    }

}