impl Solution {

    pub fn first_missing_positive ( nums: &mut Vec<i32> ) -> i32 {

        Self::mark_negatives_as_zero( nums );

        Self::make_negative_if_exists( nums );

        return Self::check_for_negative( nums );

    }

    pub fn mark_negatives_as_zero ( nums: &mut Vec<i32> ) {

        for index in 0..nums.len() {

            if nums[index] < 0 {

                nums[index] = 0;

            }

        }

    }

    pub fn make_negative_if_exists ( nums: &mut Vec<i32> ) {

        for index in 0..nums.len() {

            let element = nums[index];

            if element > 0 && element <= nums.len() as i32 + 1 {

                nums[(element - 1) as usize] = -1 * nums[(element - 1) as usize].abs()

            }

        }

    }

    pub fn check_for_negative ( nums: &mut Vec<i32> ) -> i32 {

        for number in 1..nums.len() as i32 + 1 {

            if nums[(number - 1) as usize] < 0 {

                return number;

            }

        }

        0

    }

}

fn main() {}