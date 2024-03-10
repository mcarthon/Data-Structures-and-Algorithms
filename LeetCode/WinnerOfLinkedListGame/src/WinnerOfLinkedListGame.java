public class WinnerOfLinkedListGame {

    public static void main ( String [] args ) {

        WinnerOfLinkedListGame winner = new WinnerOfLinkedListGame();

//        [2,5,4,7,20,5]

        ListNode fiveLast = new ListNode ( 5 );
        ListNode twenty = new ListNode ( 20, fiveLast );
        ListNode seven = new ListNode ( 7, twenty );
        ListNode four = new ListNode ( 4, seven );
        ListNode five = new ListNode ( 5, four );
        ListNode two = new ListNode ( 2, five );

        System.out.println ( winner.gameResult ( two ) );

    }

    public String gameResult ( ListNode head ) {

        return this.helper ( head, 0, 0 );

    }

    public String helper ( ListNode currentNode, int evenScore, int oddScore ) {

        if ( currentNode == null ) {

            if ( evenScore > oddScore ) {

                return "Even";

            }

            if ( oddScore > evenScore ) {

                return "Odd";

            }

            return "Tie";

        }

        if ( currentNode.val > currentNode.next.val ) {

            evenScore ++;

        }

        if ( currentNode.val < currentNode.next.val ) {

            oddScore ++;

        }

        return this.helper ( currentNode.next.next, evenScore, oddScore );

    }

}