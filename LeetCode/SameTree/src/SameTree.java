public class SameTree {

    static boolean isSameTree = true;

    public static void main ( String [] args ) {

        TreeNode node1Left = new TreeNode ( 2 );
        TreeNode node1Right = new TreeNode ( 3 );
        TreeNode node1 = new TreeNode ( 1, node1Left, node1Right );

        TreeNode node2Left = new TreeNode ( 2 );
        TreeNode node2Right = new TreeNode ( 3 );
        TreeNode node2 = new TreeNode ( 1, node2Left, node2Right );

        System.out.println ( sameTree ( null, null ) );

    }

    static boolean sameTree ( TreeNode node1, TreeNode node2 ) {

        if ( node1 != null && node2 != null ) {

            if ( node1.val != node2.val ) {

                isSameTree = false;

                return isSameTree;

            }

            sameTree ( node1.left, node2.left );

            sameTree ( node1.right, node2.right );

        }

        else if ( node1 == null && node2 != null || node1 != null && node2 == null ) {

            isSameTree = false;

            return isSameTree;

        }

        return isSameTree;

    }

}