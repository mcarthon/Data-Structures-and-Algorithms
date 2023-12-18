public class MaxTwinSumLinkedList {

    public static void main ( String [] args ) {

        ListNode head = new ListNode ( 0 );

        ListNode two = new ListNode ( 2 );

        ListNode three = new ListNode ( 3 );

        ListNode one = new ListNode ( 1 );

        head.next = two;

        two.next = three;

        three.next = one;

        System.out.println ( pairSum ( head ) );

    }

    static int pairSum ( ListNode head ) {

        int maxSum = 0;

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

        ListNode secondHalf = slow.next;

        slow.next = null;

        ListNode previous = null;

        while ( secondHalf != null ) {

            ListNode originalNext = secondHalf.next;

            secondHalf.next = previous;

            previous = secondHalf;

            secondHalf = originalNext;


        }

        ListNode headRunner = head;

        while ( headRunner != null ) {

            int sum = headRunner.val + fast.val;

            if ( sum > maxSum ) {

                maxSum = sum;

            }

            headRunner = headRunner.next;

            fast = fast.next;

        }

        return maxSum;

    }

}