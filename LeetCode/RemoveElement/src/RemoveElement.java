public class RemoveElement {

    public static void main ( String [] args ) {

        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println ( removeElement( array, 2 ) );

    }

    static int removeElement ( int[] nums, int val ) {

       int left = moveLeftPointer  ( 0, val, nums );

       int right = moveRightPointer ( nums.length - 1, val, nums );

       while ( left < right ) {

           if ( nums[left] == val ) {

               swap ( nums, left, right );

           }

           left = moveLeftPointer ( left, val, nums );

           right = moveRightPointer ( right, val, nums );

       }

       return left;

    }
    static void swap ( int[] array, int left, int right ) {

        int temp = array[left];

        array[left] = array[right];

        array[right] = temp;

    }

    static int moveRightPointer ( int right, int val, int[] array ) {

        while ( right > 0 && array[right] == val ) {

            right --;

        }

        return right;

    }

    static int moveLeftPointer ( int left, int val, int[] array ) {

        while ( left < array.length && array[left] != val ) {

            left ++;

        }

        return left;

    }



}