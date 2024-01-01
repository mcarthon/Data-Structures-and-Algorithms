public class LinkedListCycle {

    public static void main ( String [] args ) {

        ListNode three = new ListNode ( 3 );
        ListNode two = new ListNode ( 2, three );
        ListNode head = new ListNode ( 1, two );

        three.next = head;

        System.out.println ( hasCycle ( head ) );

    }

    static boolean isCycle = false;

    static boolean hasCycle ( ListNode head ) {

        if ( head == null ) {

            return isCycle;

        }

        if ( head.val == 100001 ) {

            isCycle = true;

            return true;

        }

        head.val = 100001;

        hasCycle ( head.next );

        return isCycle;

    }

}