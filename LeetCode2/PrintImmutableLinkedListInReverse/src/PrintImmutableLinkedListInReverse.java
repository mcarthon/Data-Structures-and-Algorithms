import java.util.Stack;

public class PrintImmutableLinkedListInReverse {

    public void printLinkedListInReverse ( ImmutableListNode head ) {

        Stack<ImmutableListNode> stack = new Stack<ImmutableListNode>();

        ImmutableListNode runner = head;

        while ( runner != null ) {

            stack.push ( runner );

            runner = runner.getNext();

        }

        while ( !stack.isEmpty() ) {

            ImmutableListNode currentNode = stack.pop();

            currentNode.printValue();;

        }

    }

}
