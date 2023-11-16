import re;

class Solution:

    def __init__ ( self ):

        input = "A man, a plan, a canal: Panama.";

        print ( self.isPalindrome ( input = input ) );

        input = "race a car";

        print ( self.isPalindrome ( input = input ) );

        input = " ";

        print ( self.isPalindrome ( input = input ) );

    def isPalindrome ( self, input: str ) -> bool:

        pattern = r"[^a-zA-Z0-9]";

        repl = "";

        input = re.sub ( pattern = pattern, repl = repl, string = input ).lower ();

        leftPointer = 0;

        rightPointer = len ( input ) - 1;

        while ( leftPointer < rightPointer ):

            if ( input [ leftPointer ] != input [ rightPointer ] ):

                return False;
            
            leftPointer += 1;

            rightPointer -= 1;

        return True;

Solution ();        