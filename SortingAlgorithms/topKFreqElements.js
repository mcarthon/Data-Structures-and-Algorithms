function find_top_k_frequent_elements ( array, k ) {

    let frequencyMap = {};
    
    array.forEach ( element => {

        frequencyMap[element] = !frequencyMap[element] ? 1 : frequencyMap[element] + 1;

    } );
    
    let keys = Object.keys ( frequencyMap );    

    keys.sort ( ( element1, element2 ) => frequencyMap[element2] - frequencyMap[element1] );

    keys = keys.map ( Number );

    return keys.slice ( 0, k );

}

console.log ( find_top_k_frequent_elements ( [1, 2, 3, 2, 4, 3, 1], 2 ) );