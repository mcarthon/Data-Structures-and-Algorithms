public class PrintLinkedListInReverse {

    public static void main ( String [] args ) {

        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode newHead = reverseLinkedList ( one );

        printLinkedListInReverse ( newHead );

    }

    static ListNode reverseLinkedList ( ListNode head ) {

        ListNode previous = null;

        ListNode current = head;

        while ( current != null ) {

            ListNode oldNext = current.next;

            current.next = previous;

            previous = current;

            current = oldNext;

        }

        return previous;

    }

    static void printLinkedListInReverse ( ListNode head ) {

        while ( head != null ) {

            System.out.println ( head.val );

            head = head.next;

        }

    }

}