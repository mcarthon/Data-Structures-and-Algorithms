import java.util.Arrays;
import java.util.Comparator;

public class SortingTheSentence {

    public static void main ( String [] args ) {

        String string = "is2 sentence4 This1 a3";

        System.out.println ( sortSentence ( string ) );

    }

    static String sortSentence ( String string ) {

        String [] stringList = string.split ( " " );

        Arrays.sort ( stringList, new SortSentenceComparator () );

        stringList = Arrays.stream ( stringList )
                        .map ( element -> element.substring ( 0, element.length() - 1 ) )
                        .toArray ( String []:: new );

        return String.join ( " ", stringList );

    }



}

class SortSentenceComparator implements Comparator < String > {

    @Override
    public int compare ( String string1, String string2 ) {

        return Integer.compare ( string1.charAt ( string1.length() - 1 ), string2.charAt ( string2.length() - 1 ) );

    }

}
