import java.util.*;

public class MinNumOfKeypresses {

    public static void main ( String [] args ) {

        MinNumOfKeypresses minKeypress = new MinNumOfKeypresses();

        System.out.println ( minKeypress.minimumKeypresses ( "aaaaaaaabcdefgggghijkllllllllllmmmnoppponono" ) );

    }

    public int minimumKeypresses ( String string ) {

        int length = string.length();

        LinkedHashMap<Character, Integer> map = this.createMaps ( string, length );

        return this.sumValues ( map );

    }

    public LinkedHashMap<Character, Integer> createMaps ( String string, int length ) {

        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();

        for ( int index = 0; index < length; ++ index ) {

            Character currentCharacter = string.charAt ( index );

            frequencies.put ( currentCharacter, frequencies.getOrDefault ( currentCharacter, 0  ) + 1 );

        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<> ( frequencies.entrySet() );

        Collections.sort ( entryList, Map.Entry.comparingByValue ( (a, b) -> b - a ) );

        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();

        for ( Map.Entry<Character, Integer> entry: entryList ) {

            sortedMap.put ( entry.getKey(), entry.getValue() );

        }

        return sortedMap;

    }

    public int sumValues ( LinkedHashMap<Character, Integer> map ) {

        int sum = 0;

        int count = 0;

        for ( int num: map.values() ) {

            if ( count < 9 ) {

                sum += num;

                count ++;

            }

            else if ( count < 18 ) {

                sum += 2 * num;

                count ++;

            }

            else {

                sum += 3 * num;

                count ++;

            }


        }

        return sum;

    }

}