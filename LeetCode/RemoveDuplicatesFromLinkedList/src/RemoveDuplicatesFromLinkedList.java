public class RemoveDuplicatesFromLinkedList {

    static ListNode removeDuplicates ( ListNode head ) {

        if ( head == null ) {

            return head;

        }

        ListNode slow = head;

        ListNode fast = head.next;

        while ( fast != null ) {

            if ( slow.val == fast.val ) {

                ListNode temp = fast.next;

                slow.next = temp;

                fast.next = null;

                fast = temp;

            }

            else {

                slow = slow.next;

                fast = fast.next;

            }

        }

        return head;

    }

}