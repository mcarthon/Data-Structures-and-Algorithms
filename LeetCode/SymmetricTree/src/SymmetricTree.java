public class SymmetricTree {

    static boolean symmetric = true;

    static boolean isSymmetric ( TreeNode root ) {

        if ( root.left != null && root.right != null ) {

            if ( root.left.val != root.right.val ) {

                return false;

            }

            return helper ( root.left, root.right );

        }

        else if ( root.left == null && root.right != null || root.left != null && root.right == null ) {

            return false;

        }

        return symmetric;

    }

    static boolean helper ( TreeNode node1, TreeNode node2 ) {

        if ( node1 != null && node2 != null ) {

            if ( node1.val != node2.val ) {

                symmetric = false;

                return symmetric;

            }

            helper ( node1.left, node2.right );

            helper ( node1.right, node2.left );

        }

        else if ( node1 == null && node2 != null || node1 != null && node2 == null ) {

            symmetric = false;

            return symmetric;

        }

        return  symmetric;

    }

}