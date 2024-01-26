public class Search {

    static boolean answer = false;

    static Boolean search_node_in_bst ( BinaryTreeNode root, Integer value ) {

        if ( root == null ) {

            return answer;

        }

        if ( root.value.equals( value ) ) {

            answer = true;

            return answer;

        }

        if ( value < root.value ) {

            return search_node_in_bst ( root.left, value );

        }

        else {

            return search_node_in_bst ( root.right, value );

        }

    }

}
