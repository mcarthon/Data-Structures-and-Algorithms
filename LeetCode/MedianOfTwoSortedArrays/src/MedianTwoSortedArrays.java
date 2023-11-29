public class MedianTwoSortedArrays {

    public static void main(String[] args) {


    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sizeOfMergedArray = nums1.length + nums2.length;

        int sizeOfleftPartition = (int) Math.floor((sizeOfMergedArray) / 2);

        int nums1Left = 0;

        int nums2Left = 0;

        int leftPartitionSize = 0;

        boolean leftPartitionCondition = leftPartitionSize < sizeOfleftPartition && nums1Left < nums1.length && nums2Left < nums2.length;

        while (leftPartitionCondition) {

            if (nums1[nums1Left] <= nums2[nums2Left]) {

                nums1Left++;

            } else {

                nums2Left++;

            }

            leftPartitionSize++;

        }

        boolean nums1RanOut = false;

        boolean nums2RanOut = false;

        while (leftPartitionSize < sizeOfleftPartition && nums1Left < nums1.length) {

            nums2RanOut = true;

            nums1Left++;

            leftPartitionSize++;

        }

        while (leftPartitionSize < sizeOfleftPartition && nums2Left < nums2.length) {

            nums1RanOut = true;

            nums2Left++;

            leftPartitionSize++;

        }

        int leftMax;

        int rightMin;

        if (sizeOfMergedArray % 2 == 0) {

            if (nums1RanOut) {

                if (nums1.length > 0) {

                    leftMax = Math.max(nums1[nums1.length - 1], nums2[nums2Left]);

                    rightMin = Math.min(nums2[nums2Left + 1], nums2[nums2Left + 2]);

                }

                else {

                    leftMax = nums2 [ nums2Left ];

                    rightMin = nums2 [ nums2Left + 1 ];

                }

            }

            else if ( nums2RanOut ) {

                if (nums2.length > 0) {

                    leftMax = Math.max(nums2[nums1.length - 1], nums1[nums2Left]);

                    rightMin = Math.min(nums1[nums1Left + 1], nums1[nums1Left + 2]);

                }

                else {

                    leftMax = nums1 [ nums2Left ];

                    rightMin = nums1 [ nums2Left + 1 ];

                }

            }

        }

        else {

            if ( nums1RanOut ) {

                return (double) nums2 [ nums2Left + 1 ];

            }

            else if ( nums2RanOut ) {

                return (double) nums1 [ nums1Left + 1 ];

            }

        }

        return (double) ( leftMax + rightMin ) / 2;

    }

}
