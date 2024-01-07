public class SwapNodesInPairs {

    public static void main ( String[] args ) {

        ListNode four = new ListNode (4);
        ListNode three = new ListNode (3, four);
        ListNode two = new ListNode (2, three);
        ListNode one = new ListNode (1, two);

        ListNode swapped = swapPairs ( one );

        printLinkedList ( swapped );

    }

    static ListNode swapPairs ( ListNode head ) {

        if ( head == null ) {

            return head;

        }

        ListNode dummyHead = new ListNode(0, head);

        ListNode slowRunner = dummyHead;

        ListNode fastRunner = head;

        while ( fastRunner != null && fastRunner.next != null ) {

            ListNode nextPair = fastRunner.next.next;

            ListNode next = fastRunner.next;

            next.next = fastRunner;

            slowRunner.next = next;

            fastRunner.next = nextPair;

            slowRunner = fastRunner;

            fastRunner = nextPair;

        }

        return dummyHead.next;

    }

    static void printLinkedList ( ListNode runner ) {


        while ( runner != null ) {

            System.out.println ( runner.val );

            runner = runner.next;

        }

    }

}