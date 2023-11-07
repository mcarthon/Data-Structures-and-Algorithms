class Solution:

    def __init__ ( self ):

        print ( self.kidsWithCandies ( [ 2, 3, 5, 1, 3 ], 3 ) );

    def kidsWithCandies ( self, candies: list [ int ], extraCandies: int ) -> list [ bool ]:

        result = list();

        for index in range ( len ( candies ) ):

            candies_copy = list ( candies );

            candies_copy [ index ] = candies_copy [ index ] + extraCandies;

            result.append ( self.isMax ( candies_copy, index ) );

        return result;

    def isMax ( self, candies: list [ int ], index: int ) -> bool:        

        for kid in candies:

            if kid > candies [ index ]:

                return False;

        return True;

Solution();