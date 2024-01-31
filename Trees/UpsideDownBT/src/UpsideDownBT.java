public class UpsideDownBT {

    public static void main ( String [] args ) {

        BinaryTreeNode seven = new BinaryTreeNode ( 7 );
        BinaryTreeNode six = new BinaryTreeNode ( 6 );

        BinaryTreeNode five = new BinaryTreeNode ( 5 );
        BinaryTreeNode four = new BinaryTreeNode ( 4, six, seven );

        BinaryTreeNode three = new BinaryTreeNode ( 3 );
        BinaryTreeNode two = new BinaryTreeNode ( 2, four, five );

        BinaryTreeNode one = new BinaryTreeNode ( 1, two, three );

        UpsideDownBT ud = new UpsideDownBT();

        ud.flip_upside_down ( one );

    }

    static BinaryTreeNode newHead;

    static BinaryTreeNode flip_upside_down ( BinaryTreeNode root ) {

        if ( root == null || root.left == null ) {

            return root;

        }

        return helper ( root, root.left );

    }

    static BinaryTreeNode helper ( BinaryTreeNode previousNode, BinaryTreeNode currentNode ) {

        if ( currentNode.left == null ) {

            newHead = currentNode;

            currentNode.right = previousNode;

            currentNode.left = previousNode.right;

            previousNode.left = null;

            previousNode.right = null;

            return newHead;

        }

        helper ( currentNode, currentNode.left );

        currentNode.right = previousNode;

        currentNode.left = previousNode.right;

        previousNode.left = null;

        previousNode.right = null;

        return newHead;

    }

}