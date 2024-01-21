import java.util.Arrays;

public class RotateArray {

    public static void main (String [] args) {

        int[] nums = { 1, 2 };

        RotateArray ra = new RotateArray();

        ra.rotate ( nums, 3 );

    }

    public void rotate(int[] nums, int k) {

        int length = nums.length;

        k = k % length;

        reverseArray ( nums, 0, length - 1 );

        reverseArray ( nums, 0, k - 1 );

        reverseArray ( nums, k, length - 1 );

        System.out.println ( Arrays.toString ( nums ) );

    }

    public void swap (int left, int right, int[] nums) {

        int temp = nums[left];

        nums[left] = nums[right];

        nums[right] = temp;

    }

    public void reverseArray ( int[] nums, int left, int right ) {

        int end = left + ( right - left ) / 2;

        while ( left <= end ) {

            swap ( left ++, right --, nums );

        }

    }

}