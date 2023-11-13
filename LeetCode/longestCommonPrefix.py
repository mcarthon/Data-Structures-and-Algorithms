def longestCommonPrefix ( strings ):

    if len ( strings ) == 0: 

        return ""

    if len ( strings ) == 1:

        return strings [ 0 ]

    commonChars = ""

    minWordLength = len ( strings [ 0 ] )

    for word in strings:

        if len ( word ) < minWordLength:

            minWordLength = len ( word )
 
    for index in range ( minWordLength ):
    
        for word in strings:

            if word [ index ] != strings [ 0 ] [ index ]:
            
                return commonChars

        commonChars += strings [ 0 ] [ index ]

    return commonChars

print ( longestCommonPrefix ( [ "fish", "fishes" ] ) )

print ( longestCommonPrefix ( [ "", "" ] ) )

print ( longestCommonPrefix ( [ "tart", "fishes" ] ) )

