public class ConvertLinkedListToBST {

    public static void main ( String [] args ) {

//        ListNode nine = new ListNode ( 9 );
//        ListNode five = new ListNode ( 5, nine );
//        ListNode zero = new ListNode ( 0, five );
//        ListNode negThree = new ListNode ( -3, zero );
//        ListNode negTen = new ListNode ( -10, negThree );

        ListNode two = new ListNode ( 2 );
        ListNode one = new ListNode ( 1, two );
        ListNode zero = new ListNode ( 0, one );
        ListNode negOne = new ListNode ( -1, zero );

        ConvertLinkedListToBST con = new ConvertLinkedListToBST();

        con.sortedListToBST ( negOne );

    }

    public TreeNode sortedListToBST ( ListNode head ) {

        return this.helper ( head );

    }

    public TreeNode helper ( ListNode head ) {

        if ( head == null ) {

            return null;

        }

        ListNode middleNode = this.middleNode ( head );

        ListNode secondhalf = middleNode.next;

        middleNode.next = null;

        TreeNode root = new TreeNode ( middleNode.val );

        if ( head == middleNode ) {

            return root;

        }

        root.left = this.helper ( head );

        root.right = this.helper ( secondhalf );

        return root;

    }

    public ListNode middleNode ( ListNode head ) {

        ListNode previous = head;

        ListNode slow = head;

        ListNode fast = head;

        while ( fast.next != null ) {

            if ( fast.next.next != null ) {

                fast = fast.next.next;

            }

            else  {

                fast = fast.next;

            }

            previous = slow;

            slow = slow.next;

        }

        if ( previous != null ) {

            previous.next = null;

        }

        return slow;

    }

}