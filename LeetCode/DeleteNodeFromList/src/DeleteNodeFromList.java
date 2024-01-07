public class DeleteNodeFromList {

    static void deleteNode ( ListNode node ) {

        ListNode nextNode = node.next;

        node.val = nextNode.val;

        node.next = nextNode.next;

        nextNode.next = null;

    }

}