import java.util.ArrayList;

public class DeleteFromBST {

    public static void main ( String [] args ) {

//        BinaryTreeNode negOne = new BinaryTreeNode ( -1 );
        BinaryTreeNode five = new BinaryTreeNode ( 5 );

//        BinaryTreeNode three = new BinaryTreeNode ( 3, negOne, five );
//        BinaryTreeNode eleven = new BinaryTreeNode ( 11, null, null );
//
//        BinaryTreeNode ten = new BinaryTreeNode ( 10, three, eleven );

        ArrayList<Integer> values = new ArrayList<Integer>();

//        values.add ( 3 );
//        values.add ( 6 );
//        values.add ( 9 );

        values.add ( 5 );

        delete_from_bst ( five, values );

    }

    static BinaryTreeNode delete_from_bst ( BinaryTreeNode root, ArrayList<Integer> values_to_be_deleted ) {

        for ( Integer value : values_to_be_deleted ) {

            root = delete ( null, root, value, root );

        }

        return root;

    }

    static BinaryTreeNode delete ( BinaryTreeNode previous, BinaryTreeNode currentNode, Integer valueToDelete, BinaryTreeNode root ) {

        if ( currentNode == null ) {

            return root;

        }

        if ( valueToDelete == currentNode.value ) {

            if ( currentNode.left == null && currentNode.right == null ) {

                root = noChildren ( previous, currentNode, root );

            }

            else if ( currentNode.left == null || currentNode.right == null ) {

                oneChild ( previous, currentNode );

            }

            else {

                twoChildren ( currentNode, previous, currentNode );

            }

            return root;

        }

        if ( valueToDelete < currentNode.value ) {

            delete ( currentNode, currentNode.left, valueToDelete, root );

        }

        else {

            delete ( currentNode, currentNode.right, valueToDelete, root );

        }

        return root;

    }

    static BinaryTreeNode noChildren ( BinaryTreeNode previous, BinaryTreeNode currentNode, BinaryTreeNode root ) {

        if ( previous == null ) {

            root = null;

        }

        else if ( currentNode.value < previous.value ) {

            previous.left = null;

        }

        else {

            previous.right = null;

        }

        return root;

    }

    static void oneChild ( BinaryTreeNode previous, BinaryTreeNode currentNode ) {

        if ( currentNode.value < previous.value ) {

            if ( currentNode.left != null ) {

                previous.left = currentNode.left;

            }

            else {

                previous.left = currentNode.right;

            }

        }

        else {

            if ( currentNode.left != null ) {

                previous.right = currentNode.left;

            }

            else {

                previous.right = currentNode.right;

            }

        }

    }

    static void twoChildren ( BinaryTreeNode rootOfSubtree, BinaryTreeNode previous, BinaryTreeNode successor ) {

        if ( successor.right == null ) {

            rootOfSubtree.value = successor.value;

            previous.right = null;

            return;

        }

        twoChildren ( rootOfSubtree, successor, successor.right );

    }

}