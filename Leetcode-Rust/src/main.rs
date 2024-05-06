fn first_missing_positive ( nums: Vec<i32> ) -> i32 {

    if ( nums.len() as i32 == 1 ) {

        return singletons ( nums );

    }

    let mut nums = nums;

    mark_negatives_as_zero ( &mut nums );

    make_negative_if_exists ( &mut nums );

    return check_for_negative ( &nums );

}

fn mark_negatives_as_zero ( nums: &mut Vec<i32> ) {

    for num in nums.iter_mut() {

        if *num < 0 {

            *num = 0;

        }

    }

}

fn make_negative_if_exists ( nums: &mut Vec<i32> ) {

    for index in 0..nums.len() {

        let element = nums[index].abs();

        if element > 0 && (element - 1) < nums.len() as i32 {

            if nums[ (element - 1) as usize] != 0 {

                nums[ (element - 1) as usize ] = -1 * nums[ (element - 1) as usize ].abs()

            }

            else {

                nums[ (element - 1) as usize ] = -1 * (nums.len() as i32 + 2);

            }

        }

    }

}

fn check_for_negative ( nums: &Vec<i32> ) -> i32 {

    for number in 1..nums.len() as i32 + 1 {

        if nums[ (number - 1) as usize] >= 0 {

            return number;

        }

    }

    nums.len() as i32 + 1

}

fn singletons ( nums: Vec<i32> ) -> i32 {

    let mut number: i32 = 1;

    while number <= nums.len() as i32 {

        if nums[ 0 as usize ] != number {

            return number

        }

        number += 1

    }

    nums.len() as i32+ 1

}

fn main() {

    let nums: Vec<i32> = vec![3, 4, -1, 1];

    println!("{}", first_missing_positive ( nums ));

}