import java.util.ArrayList;

public class DeleteFromBST {

    public static void main ( String [] args ) {

//        BinaryTreeNode negOne = new BinaryTreeNode ( -1 );
//        BinaryTreeNode five = new BinaryTreeNode ( 5 );
//
//        BinaryTreeNode three = new BinaryTreeNode ( 3, negOne, five );
//        BinaryTreeNode eleven = new BinaryTreeNode ( 11, null, null );
//
//        BinaryTreeNode ten = new BinaryTreeNode ( 10, three, eleven );

//        BinaryTreeNode negOneBillion = new BinaryTreeNode ( -1000000000 );
//        BinaryTreeNode posOneBillion = new BinaryTreeNode ( 1000000000 );
//
//        BinaryTreeNode oneHundred = new BinaryTreeNode ( 100, negOneBillion, null );
//        BinaryTreeNode twoHundred = new BinaryTreeNode ( 200, null, posOneBillion );
//
//        BinaryTreeNode oneTwenty = new BinaryTreeNode ( 120, oneHundred, twoHundred );

        BinaryTreeNode ten = new BinaryTreeNode ( 10 );
        BinaryTreeNode eight = new BinaryTreeNode ( 8, null, ten );
        BinaryTreeNode seven = new BinaryTreeNode ( 7, null, eight );
        BinaryTreeNode six = new BinaryTreeNode ( 6, null, seven );
        BinaryTreeNode five = new BinaryTreeNode ( 5, null, six );

        ArrayList<Integer> values = new ArrayList<Integer>();

//        values.add ( 3 );
//        values.add ( 6 );
//        values.add ( 9 );

//        values.add ( 5 );

//        values.add ( 1000000000 );
//        values.add ( 100 );
//        values.add ( 120 );

        values.add ( 5 );
        values.add ( 6 );
        values.add ( 7 );
        values.add ( 8 );

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

                root = oneChild ( previous, currentNode, root );

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

    static BinaryTreeNode oneChild ( BinaryTreeNode previous, BinaryTreeNode currentNode, BinaryTreeNode root ) {

        if ( previous == null ) {

            if ( currentNode.left != null ) {

                root = currentNode.left;

            }

            else {

                root = currentNode.right;

            }

        }

        else if ( currentNode.value < previous.value ) {

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

        return root;

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