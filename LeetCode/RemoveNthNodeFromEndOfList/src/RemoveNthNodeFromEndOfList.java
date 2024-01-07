public class RemoveNthNodeFromEndOfList {

    public static void main ( String [] args ) {

        ListNode five = new ListNode ( 5 );
        ListNode four = new ListNode ( 4, five );
        ListNode three = new ListNode ( 3, four );
        ListNode two = new ListNode ( 2, three );
        ListNode one = new ListNode ( 1, two );

        ListNode newHead = remove ( one, 2 );

        printLinkedList ( newHead );

    }

    static ListNode remove ( ListNode head, int n ) {

        ListNode runner = head;

        int size = 1;

        while ( runner.next != null ) {

            runner = runner.next;

            size ++;

        }

        if ( n == size ) {

            return head.next;

        }

        ListNode secondRunner = head;

        int nodeNumber = 1;

        while ( nodeNumber < size - n ) {

            nodeNumber ++;

            secondRunner = secondRunner.next;

        }

        ListNode nodeToRemove = secondRunner.next;

        ListNode newNext = secondRunner.next.next;

        secondRunner.next = newNext;

        nodeToRemove.next = null;

        return head;

    }

    static void printLinkedList ( ListNode head ) {

        while ( head != null ) {

            System.out.println ( head.val );

            head = head.next;

        }

    }

}