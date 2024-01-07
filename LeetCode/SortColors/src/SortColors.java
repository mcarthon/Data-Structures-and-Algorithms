import java.util.Arrays;

public class SortColors {

    public static void main ( String [] args ) {

        int [] nums = { 2, 0, 2, 1, 1, 0 };

        sortColors ( nums );

        System.out.println (Arrays.toString(nums));

    }

    static void sortColors ( int [] nums ) {

        if ( nums.length < 2 ) {

            return;

        }

        int left = 0;
        int right = nums.length - 1;

        while ( nums[left] == 0 ) {

            left ++;

            if ( left >= nums.length ) {

                return;

            }

        };

        while ( nums[right] == 2 ) {

            right --;

            if ( right < 0 ) {

                return;

            }

        }

        int middle = left;

        while ( middle <= right ) {

            if ( nums [ middle ] == 2 ) {

                swap ( nums, middle, right -- );

                while ( nums[right] == 2 ) {

                    right --;

                    if ( right < 0 ) {

                        return;

                    }

                }

            }

            else if ( nums [ middle ] == 1 ) {

                middle ++;

            }

            else {

                swap ( nums, middle, left ++ );

                while ( nums[left] == 0 ) {

                    left ++;

                    if ( left >= nums.length ) {

                        return;

                    }

                };

                middle = left;

            }

        }

    }

    static void swap ( int[] array, int left, int right ) {

        int temp = array[left];

        array[left] = array[right];

        array[right] = temp;

    }

}