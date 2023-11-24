package code;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] nums1 = { 0, 0, 3, 0, 0, 0, 0, 0, 0 };
		
		int[] nums2 = { -1, 1, 1, 1, 2, 3 };
		
		System.out.println ( merge ( nums1, 3, nums2, 6 ) );

	}
	
	static int [] merge ( int[] nums1, int m, int[] nums2, int n ) {		
		
		int nums1Pointer = m - 1;
		
		int nums2Pointer = n - 1;
		
		int insertIndex = nums1.length - 1;
		
		while ( nums2Pointer > -1 ) {
			
			if ( nums1Pointer > -1 && nums1 [ nums1Pointer ] > nums2 [ nums2Pointer ] ) {
				
				nums1 [ insertIndex -- ] = nums1 [ nums1Pointer -- ];
				
			}
			
			else {
				
				nums1 [ insertIndex -- ] = nums2 [ nums2Pointer -- ];
				
			}	
			
		}
		
		return nums1;
		
	}

}
