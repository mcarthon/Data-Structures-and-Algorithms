function two_sum ( numbers, target ) {

    let sortedNums = [ ...numbers ];

    let isSorted = false;
 
    for ( let index = 1; index < numbers.length; ++ index ) {
        
        if ( numbers[index - 1] > numbers [index] ) {
            
            sortedNums.sort( (a,b) => a - b );

            isSorted = true;
            
            break;
            
        }
        
    }
 
    let left = 0; 
    
    let right = numbers.length - 1;
    
    while ( left < right ) {
        
        let sum = sortedNums[left] + sortedNums[right];
        
        if ( sum < target ) {
            
            left ++;
            
        }
        
        else if ( sum > target ) {
            
            right --;
            
        }
        
        else {
            
            let originalLeft = left;

            let originalRight = right;
            
            if ( isSorted ) {

                originalLeft = numbers.indexOf ( sortedNums[left] );
                
                originalRight = numbers.indexOf ( sortedNums[right] );

            }
            
            if ( originalLeft === originalRight ) {

                originalRight ++;

            }
            
            return [ originalLeft, originalRight ];
            
        }                
        
    }

    return [-1, -1];
 
}

console.log ( two_sum ( [ 5, 5, 5, 5, 5, 5 ], 10 ) );