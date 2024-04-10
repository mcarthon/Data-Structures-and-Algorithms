public class Solution {

    public int timeRequiredToBuy ( int[] tickets, int k ) {

        int time = 0;

        int length = tickets.length;

        int target = tickets [ k ];

        for ( int index = 0; index < length; ++ index ) {

            int currentNumber = tickets [ index ];

            if ( index < k ) {

                if ( currentNumber <= target ) {

                    time += currentNumber;

                }

                else {

                    time += target;

                }

            }

            else if ( index == k ) {

                time += target;

            }

            else {

                if ( currentNumber >= target ) {

                    time += target - 1;

                }

                else {

                    time += currentNumber;

                }

            }

        }

        return time;

    }

}