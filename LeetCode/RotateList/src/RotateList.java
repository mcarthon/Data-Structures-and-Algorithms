public class RotateList {

    public static void main ( String [] args ) {

        ListNode five = new ListNode ( 5 );
        ListNode four = new ListNode ( 4, five );
        ListNode three = new ListNode ( 3, four );
        ListNode two = new ListNode ( 2, three );
        ListNode one = new ListNode ( 1, two );

        RotateList rl = new RotateList ();

        ListNode result = rl.rotateRight ( one, 5 );

        rl.printLinkedList ( result );

    }

    public ListNode rotateRight ( ListNode head, int k ) {

        if ( head == null ) {

            return head;

        }

        int length = this.lengthOfList ( head );

        k = k % length;

        if ( k == 0 ) {

            return head;

        }

        ListNode slow = head;

        for ( int count = 0; count < length - 1 - k; ++ count ) {

            slow = slow.next;

        }

        ListNode newHead = slow.next;

        slow.next = null;

        ListNode newHeadRunner = newHead;

        while ( newHeadRunner.next != null ) {

            newHeadRunner = newHeadRunner.next;

        }

        newHeadRunner.next = head;

        return newHead;

    }

    public int lengthOfList ( ListNode head ) {

        int length = 0;

        while ( head != null ) {

            length ++;

            head = head.next;

        }

        return length;

    }

    public void printLinkedList ( ListNode head ) {

        while ( head != null ) {

            System.out.println ( head.val );

            head = head.next;

        }

    }

}