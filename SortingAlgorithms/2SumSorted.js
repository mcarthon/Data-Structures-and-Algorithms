function pair_sum_sorted_array ( numbers, target ) {
    
    let left = 0;

    let right = numbers.length - 1;

    while ( left < right ) {

        let sum = numbers[left] + numbers[right];

        if ( sum < target ) {

            left++;

        }

        else if ( sum > target ) {

            right --;

        }

        else {

            return [ left, right ];

        }

        return [-1, -1];

    }

}

console.log ( pair_sum_sorted_array ( [1, 2, 3, 5, 10], 7 ) );