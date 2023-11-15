class Solution:

    def __init__ ( self ):

        self.numeral_hashmap = {

            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M":1000

        }

        print ( self.numeral_to_num ( "XXXIV" ) );

    def numeral_to_num ( self, string: str ) -> int:

        sum = 0;

        for index in range ( len ( string ) -1 ):

            current = self.numeral_hashmap [ string [ index ] ];

            next = self.numeral_hashmap [ string [ index + 1 ] ];

            if next > current:

                sum -= current;

            else:

                sum += current;

        last = self.numeral_hashmap [ string [ -1 ] ];

        sum += last;

        return sum; 

Solution ();        