class Solution:

    def __init__ ( self ):

        self.hashmap = [

            [ "M",  1000 ],
            [ "CM", 900 ],
            [ "D",  500 ],
            [ "CD", 400 ],
            [ "C",  100 ],
            [ "XC", 90 ],
            [ "L",  50 ],
            [ "XL", 40 ],
            [ "X",  10 ],
            [ "IX", 9 ],
            [ "V",  5 ],
            [ "IV", 4 ],
            [ "I",  1 ]

        ];

        self.roman = "";

        print ( self.intToRoman ( 1134 ) );

    def intToRoman(self, input: int) -> str:

        for numeral, value in self.hashmap:

            self.roman += str ( numeral * ( input // value ) );

            input %= value;

        return self.roman;

Solution ();        