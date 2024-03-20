import java.util.Arrays;

public class RotateArray {

    public static void main (String[] args) {

        RotateArray ra = new RotateArray();

        int[] input = { 0,1,2,3,4,5,6,7,8,9 };

        System.out.println (Arrays.toString(ra.rotateArray(input, 3)));

    }

    public int[] rotateArray ( int[] array, int k ) {

        int length = array.length;
        k = k % length;

        this.reverseArray ( array, 0, length - 1 );
        this.reverseArray ( array, 0, k - 1 );
        this.reverseArray ( array, k, length - 1 );

        return array;

    }

    public void reverseArray ( int[] array, int left, int right ) {

        while ( left < right ) {

            this.swap ( array, left ++, right -- );

        }

    }

    public void swap ( int[] array, int left, int right ) {

        int temp = array[left];

        array[left] = array[right];

        array[right] = temp;

    }

}