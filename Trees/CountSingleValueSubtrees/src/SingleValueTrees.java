public class SingleValueTrees {

    static int count = 0;

    static boolean isUnivalued = true;

    static Integer find_single_value_trees ( BinaryTreeNode node ) {

        if ( node == null ) {

            return (Integer) count;

        }

        count += checkValues ( node, node.value ) ? 1 : 0;

        isUnivalued = true;

        find_single_value_trees ( node.left );

        find_single_value_trees ( node.right );

        return (Integer) count;

    }

    static boolean checkValues ( BinaryTreeNode node, int value ) {

        if ( node == null ) {

            return isUnivalued;

        }

        if ( node.value != value ) {

            isUnivalued = false;

            return isUnivalued;

        }

        if ( !checkValues ( node.left, value )
                || !checkValues ( node.right, value ) ) {

            return isUnivalued;

        }

        return isUnivalued;

    }

}