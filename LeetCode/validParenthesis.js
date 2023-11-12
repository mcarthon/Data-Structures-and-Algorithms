var isValid = function(s) {

    stack = [];

    hash = {

        "}": "{",
        ")":"(",
        "]":"["

    }

    for ( index = 0; index < s.length; ++ index ) {

        if ( Object.values ( hash ).includes ( s [ index ] ) ) {

            stack.push ( s [ index ] );

        }

        else {

            if ( stack [ stack.length - 1 ] !== hash [ s [ index ] ] ) {

                return false;

            }

            else {

                stack.pop ()

            }

        }

    }

    if ( stack.length === 0 ) {

        return true;

    }

    return false;

};

// input
// ( { [ } ] )

// stack
// ( { [ 

console.log ( isValid ( "({[}])" ) );

console.log ( isValid ( "({}[])" ) );