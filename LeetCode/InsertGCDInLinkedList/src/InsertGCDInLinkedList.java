public class InsertGCDInLinkedList {

    static ListNode insertGCD ( ListNode head ) {

        if ( head.next == null ) {

            return head;

        }

        ListNode first = head;
        ListNode second = head.next;

        while ( second != null ) {

            int gcd = euclideanAlgo ( first.val, second.val );

            ListNode newNode = new ListNode ( gcd, second );

            first.next = newNode;

            first = second;

            second = second.next;

        }

        return head;

    }

    static int euclideanAlgo ( int a, int b ) {

        return b == 0? a: euclideanAlgo(b, a % b);

    }

}