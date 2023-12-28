public class RemoveDuplicates {

    static int removeDuplicates ( int[] nums ) {

        if ( nums.length < 2 ) {

            return nums.length;

        }

        int left = 0;
        int right = 1;

        while ( right < nums.length ) {

            if ( nums[right] > nums[left] ) {

                left ++;

                swap ( nums, left, right ++ );

            }

            else {

                right ++;

            }

        }
        return left + 1;

    }

    static void swap ( int[] array, int left, int right ) {

        int temp = array[left];

        array[left] = array[right];

        array[right] = temp;

    }

}