import java.util.ArrayList;

public class PalindromeLinkedList {

    public static void main ( String [] args ) {

    ListNode head = null;

//    ListNode head = new ListNode ( 1 );

//    ListNode two = new ListNode ( 2 );

//    ListNode three = new ListNode ( 2 );

//    ListNode four = new ListNode ( 1 );

//    head.next = two;

//    head.next.next = three;

//    head.next = four;

    System.out.println ( isPalindrome ( head ) );

    }

    static boolean isPalindrome ( ListNode head ) {

        if ( head == null ) {

            return true;

        }

        ListNode slow = head;

        ListNode fast = head;

        while ( fast.next != null ) {

            if ( fast.next.next != null ) {

                fast = fast.next.next;

                slow = slow.next;

            }

            else {

                fast = fast.next;

            }

        }

        ListNode originalSlow = slow;

        slow = slow.next;

        ListNode previous = null;

        while ( slow != null ) {

            ListNode originalNext = slow.next;

            slow.next = previous;

            previous = slow;

            slow = originalNext;

        }

        originalSlow.next = null;

        return checkPalindrome ( head, fast );

    }

    static boolean checkPalindrome ( ListNode head, ListNode tail ) {

        while ( head != null && tail != null ) {

            if ( head.val != tail.val ) {

                return false;

            }

            head = head.next;

            tail = tail.next;

        }

        return true;

    }

//    static boolean isPali ( ListNode slow, ListNode fast ) {
//
//
//
//    }

}