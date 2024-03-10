import java.util.HashMap;

public class CopyListWithRandomPointer {

    public static void main ( String [] args ) {

        CopyListWithRandomPointer copyList = new CopyListWithRandomPointer();

        Node one = new Node ( 1 );
        Node two = new Node ( 2 );
        one.next = two;
        one.random = one;
        two.random = one;

        Node result = copyList.copyRandomList ( one );

        copyList.displayLinkedList ( result );

    }

    public HashMap<Node, Node> createHash ( Node head ) {

        HashMap<Node, Node> result = new HashMap<Node, Node>();

        for ( Node runner = head; runner != null; runner = runner.next ) {

            Node newNode = new Node ( runner.val );

            result.put ( runner, newNode );

        }

        return result;

    }

    public void connectNodes ( HashMap<Node, Node> map ) {

        for ( Node node : map.keySet() ) {

            Node copy = map.get ( node );

            copy.next = map.get ( node.next );

            copy.random = map.get ( node.random );

        }

    }

    public Node copyRandomList ( Node head ) {

        HashMap<Node, Node> map = this.createHash ( head );

        this.connectNodes ( map );

        return map.get ( head );

    }

    public void displayLinkedList ( Node node ) {

        for ( Node runner = node; runner != null; runner = runner.next ) {

            if ( runner.next != null ) {

                String string = String.format ( "Node: %d\nNext: %d\nRandom: %d\n\n", runner.val, runner.next.val, runner.random.val );

                System.out.println ( string );

            }

            else {

                String string = String.format ( "Node: %d\nNext: null\nRandom: %d\n\n", runner.val, runner.random.val );

                System.out.println ( string );

            }


        }

    }

}