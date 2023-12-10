public class RootEqualsSumoChildren {

    public static void main ( String [] args ) {

        TreeNode root = new TreeNode ( 1 );

        TreeNode leftChild = new TreeNode ( -1 );

        TreeNode rightChild = new TreeNode ( 2 );

        root.left = leftChild;

        root.right = rightChild;

        System.out.println ( checkTree ( root ) );

    }

    static int rootVal = 0;

    static int childSum = 0;

    static boolean checkTree ( TreeNode root ) {

        helper ( root );

        return rootVal == childSum;

    }

    static void helper ( TreeNode root ) {

        if ( root == null ) {

            return;
        }

        if ( root.left != null && root.right != null ) {

            rootVal = root.val;

        }

        else {

            childSum += root.val;

        }

        checkTree ( root.left );

        checkTree ( root.right );

    }

}