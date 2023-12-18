public class MiddleOfLinkedList {

    static ListNode middleNode ( ListNode head ) {

        if ( head.next == null ) {

            return head;

        }

        ListNode fast = head;

        ListNode slow = head;

        while ( fast.next != null ) {

            if ( fast.next.next != null ) {

                fast = fast.next.next;

            }

            else {

                fast = fast.next;

            }

            slow = slow.next;

        }

        return slow;

    }

}