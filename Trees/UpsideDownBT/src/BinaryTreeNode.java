public class BinaryTreeNode {

    int value;

    BinaryTreeNode left;

    BinaryTreeNode right;

    BinaryTreeNode () {};

    BinaryTreeNode ( int value ) {

        this.value = value;

    }

    BinaryTreeNode ( int value, BinaryTreeNode left, BinaryTreeNode right ) {

        this.value = value;

        this.left = left;

        this.right = right;

    }

}