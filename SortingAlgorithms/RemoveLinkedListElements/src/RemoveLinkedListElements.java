public class RemoveLinkedListElements {

    public static void main ( String [] args ) {

        ListNode head = new ListNode ( 0 );

        ListNode one = new ListNode ( 1 );

        ListNode two = new ListNode ( 2 );

        ListNode three = new ListNode ( 2 );

        ListNode four = new ListNode ( 4 );

        head.next = one;

        one.next = two;

        two.next = three;

        three.next = four;

        printLinkedList ( removeHeadVal ( head, 1 ) );

    }

    static ListNode removeHeadVal ( ListNode head, int val ) {

        if ( head == null ) {

            return head;

        }

        ListNode current = head;

        boolean isCurrentHead = true;

        ListNode previous = head;

        while ( current != null ) {

            if ( current != head ) {

                isCurrentHead = false;

            }

            if ( current.val == val && isCurrentHead ) {

                ListNode originalHead = current;

                current = current.next;

                previous = current;

                head = previous;

                originalHead.next = null;

            }

            else if ( current.val == val && !isCurrentHead ) {

                previous.next = current.next;

                current.next = null;

                current = previous.next;

            }

            else {

                previous = current;

                current = current.next;

            }

        }

        return head;

    }

    static void printLinkedList ( ListNode head ) {

        while ( head!= null ) {

            System.out.println ( head.val );

            head = head.next;

        }

    }

}