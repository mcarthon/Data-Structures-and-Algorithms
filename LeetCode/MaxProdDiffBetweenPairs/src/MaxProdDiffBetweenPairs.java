import java.util.Arrays;

public class MaxProdDiffBetweenPairs {

    static int maxProdDiff ( int [] numbers ) {

        Arrays.sort ( numbers );

        return ( numbers [ numbers.length - 1 ] * numbers [ numbers.length - 2 ] )
                - ( numbers [ 0 ] * numbers [ 1 ] );

    }

}