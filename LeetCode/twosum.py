class Solution:

    def __init__ ( self ):

        nums = [ -1, -2, -3, -4, -5 ];

        target = -8;

        print ( self.two_sum ( nums = nums, target = target ) );

    def two_sum ( self, nums: list[ int ], target: int ):

        nums_copy = nums.copy ();

        nums_copy.sort ();

        left = 0;

        right = len( nums ) - 1;

        while ( left < right ):

            sum = nums_copy [ left ] + nums_copy [ right ];

            if sum < target:

                left += 1;

            elif sum > target:

                right -= 1;

            else:

                left_index = nums.index ( nums_copy [ left ] );

                if nums_copy [ left ] == nums_copy [ right ]:
                
                    right_index = nums [ left_index + 1: ].index ( nums_copy [ right ] ) + left_index + 1;

                    return [ left_index, right_index ];

                else:

                    right_index = nums.index ( nums_copy [ right ] );

                    return [ left_index, right_index ];

Solution ();                