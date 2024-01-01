import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    static ListNode getIntersectionNode ( ListNode headA, ListNode headB ) {

        HashSet<ListNode> visitedNodes = new HashSet<ListNode>();

        ListNode runnerA = headA;

        while ( runnerA != null ) {

            visitedNodes.add ( runnerA );

            runnerA = runnerA.next;

        }

        ListNode runnerB = headB;

        while ( runnerB != null ) {

            if ( visitedNodes.contains ( runnerB ) ) {

                return runnerB;

            }

            visitedNodes.add ( runnerB );

            runnerB = runnerB.next;

        }

        return null;

    }

}