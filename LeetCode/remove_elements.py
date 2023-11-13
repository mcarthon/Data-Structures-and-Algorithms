def remove_element ( nums: list[int], val: int ) -> int:

    left = 0

    right = len(nums) - 1

    count = 0

    while left <= right:

        if (nums[left] == val):
            
            count += 1

            swap ( nums, left, right )

            nums.pop()

            right = len(nums) - 1

        else:
            
            left += 1

    return count, nums

def swap ( array: list[int], left: int, right: int ):

    temp = array[left]

    array[left] = array[right]

    array[right] = temp

print ( remove_element ( [-1,0,1,2,3,2,2,4], 2 ) )   

print ( remove_element ( [3,2,2,3], 3 ) )

print ( remove_element ( [0,1,2,2,3,0,4,2], 2 ) )