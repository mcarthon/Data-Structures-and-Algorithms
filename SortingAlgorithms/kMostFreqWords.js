function k_most_frequent ( k, words ) {

    words.sort();

    let frequencyMap = {};
    
    words.forEach ( word => {

        frequencyMap[word] = !frequencyMap[word] ? 1 : frequencyMap[word] + 1;

    });

    let keys = Object.keys ( frequencyMap );

    keys.sort ( (a,b) => frequencyMap[b] - frequencyMap[a] );

    return keys.slice(0, k);

}

console.log ( k_most_frequent(4, ["car", "bus", "taxi", "car", "driver", "candy", "race", "car", "driver", "fare", "taxi"]) );