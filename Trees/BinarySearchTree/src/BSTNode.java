public class BSTNode {

    int value;

    BSTNode left;

    BSTNode right;

    BSTNode () {};

    BSTNode ( int value ) {

        this.value = value;

    }

    BSTNode ( int value, BSTNode left, BSTNode right ) {

        this.value = value;

        this.left = left;

        this.right = right;

    }

}