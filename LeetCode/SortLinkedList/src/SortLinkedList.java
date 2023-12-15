public class SortLinkedList {

    public static void main ( String [] args ) {

        ListNode head = new ListNode ( 3 );

        ListNode two = new ListNode ( 2 );

        ListNode one = new ListNode ( 1 );

        ListNode zero = new ListNode ( 0 );

        head.next = two;

        two.next = one;

        one.next = zero;

        head = sortList ( head );

        printLinkedList( head );

    }

    static ListNode sortList ( ListNode head ) {

        if ( head == null || head.next == null ) {

            return head;

        }

        ListNode fast = head;

        ListNode slow = head;

        while ( fast.next != null ) {

            if ( fast.next.next != null ) {

                fast = fast.next.next;

                slow = slow.next;

            }

            else {

                fast = fast.next;

            }

        }

        ListNode firstHalf = head;

        ListNode secondHalf = slow.next;

        slow.next = null;

        firstHalf = sortList ( firstHalf );

        secondHalf = sortList ( secondHalf );

        return merge ( firstHalf, secondHalf );

    }

    static ListNode merge ( ListNode firstHalf, ListNode secondHalf ) {

        ListNode firstRunner = firstHalf;

        ListNode secondRunner = secondHalf;

        ListNode aux = new ListNode ( 0 );

        ListNode auxTail = aux;

        while ( firstRunner != null && secondRunner != null ) {

            if ( firstRunner.val <= secondRunner.val ) {

                auxTail.next = new ListNode ( firstRunner.val );

                firstRunner = firstRunner.next;

                auxTail = auxTail.next;

            }

            else {

                auxTail.next = new ListNode ( secondRunner.val );

                secondRunner = secondRunner.next;

                auxTail = auxTail.next;

            }

        }

        if ( firstRunner != null ) {

            auxTail.next = firstRunner;

        }

        if ( secondRunner != null ) {

            auxTail.next = secondRunner;

        }

        ListNode result = aux.next;

        aux.next = null;

        return result;

    }

    static void printLinkedList ( ListNode head ) {

        while ( head != null ) {

            System.out.println ( head.val );

            head = head.next;

        }

    }

}