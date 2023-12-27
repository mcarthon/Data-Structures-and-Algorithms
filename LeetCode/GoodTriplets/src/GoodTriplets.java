import java.util.Arrays;

public class GoodTriplets {

    public static void main ( String [] args ) {

//        int[] array = {3,0,1,1,9,7};
//        int a = 7;
//        int b = 2;
//        int c = 3;
//
//        System.out.println(goodTriplets(array, a, b, c));

        int[] array1 = {7,3,7,3,12,1,12,2,3};
        int a1 = 5;
        int b1 = 8;
        int c1 = 1;

        System.out.println(goodTriplets(array1, a1, b1, c1));

    }

    static int goodTriplets ( int[] array, int a, int b, int c ) {

        int count = 0;

        int i = 0;
        int j = 1;
        int k = 2;

        while ( i < array.length - 2 ) {

            int aDiff = Math.abs(array[i] - array[j]);
            int bDiff = Math.abs(array[j] - array[k]);
            int cDiff = Math.abs(array[i] - array[k]);

            boolean isGoodTriplet = aDiff <= a && bDiff <= b && cDiff <= c;

            count += isGoodTriplet? 1: 0;

            if ( k < array.length - 1 ) {

                k ++;

            }

            else if ( j < array.length - 2 ) {

                j ++;

                k = j + 1;

            }

            else {

                i ++;

                j = i + 1;

                k = j + 1;

            }

        }

        return count;

    }

}