import java.util.Arrays;

public class FlippingAnImage {

    public static void main ( String [] args ) {

        int[][] image = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };

        System.out.println (Arrays.deepToString(flipAndInvertImage(image)));

    }

    static int[][] flipAndInvertImage ( int[][] image ) {

        for ( int row = 0; row < image.length; ++ row ) {

            image[row] = horizontalFlip ( image[row] );

            image[row] = invertBinaryRow ( image[row] );

        }

        return image;

    }

    static int[] horizontalFlip ( int[] array ) {

        for ( int i = 0; i < array.length / 2; ++ i ) {

            swap ( array, i, array.length - 1 - i );

        }

        return array;

    }

    static void swap ( int[] array, int left, int right ) {

        int temp = array[left];

        array[left] = array[right];

        array[right] = temp;

    }

    static int[] invertBinaryRow ( int[] array ) {

        for ( int index = 0; index < array.length; ++ index ) {

            array[index] = array[index] == 0? 1: 0;

        }

        return array;

    }

}