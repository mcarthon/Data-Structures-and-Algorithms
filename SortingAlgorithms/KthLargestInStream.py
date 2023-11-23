def kth_largest ( k, initial_stream, append_stream ):

    result = [];

    for number in append_stream:

        initial_stream.append ( number );

        result.append ( sorted ( initial_stream, reverse = True )[ k - 1 ] );

    return result;

print ( kth_largest ( 2, [4, 6], [5, 2, 20] ) );