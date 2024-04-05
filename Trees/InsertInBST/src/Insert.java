import java.util.ArrayList;
import java.util.List;

public class Insert {

    public static void main ( String [] args ) {

        List<Integer> values = new ArrayList<Integer>();

        values.add ( 1 );
        values.add ( 2 );
        values.add ( 3 );
        values.add ( 4 );
        values.add ( 5 );


        build_a_bst ( values );

    }

    static BinaryTreeNode build_a_bst ( List<Integer> values ) {

        if ( values.isEmpty() ) {

            return null;

        }

        if ( values.size() == 1 ) {

            return new BinaryTreeNode ( values.get ( 0 ) );

        }

        BinaryTreeNode root = new BinaryTreeNode ( values.get ( 0  ) );

        for ( int index = 1; index < values.size(); ++ index ) {

            int value = values.get ( index );

            search ( null, root, value );

        }

        return root;

    }

    static void search ( BinaryTreeNode previous, BinaryTreeNode current, Integer value ) {

        if ( current == null ) {

            BinaryTreeNode newNode = new BinaryTreeNode ( value );

            if (newNode.value < previous.value ) {

                previous.left = newNode;

            }

            else {

                previous.right = newNode;

            }

            return;

        }

        if ( value < current.value ) {

            previous = current;

            current = current.left;

            search ( previous, current, value );

        }

        else {

            previous = current;

            current = current.right;

            search ( previous, current, value );

        }

    }

}