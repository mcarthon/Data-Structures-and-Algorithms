public class MaxDepthOfTree {

    public static void main ( String [] args ) {

        TreeNode root = null;

//        TreeNode nine = new TreeNode ( 9 );
//
//        TreeNode twenty = new TreeNode ( 20 );
//
//        TreeNode fifteen = new TreeNode ( 15 );
//
//        TreeNode seven = new TreeNode ( 7 );
//
//        root.left = nine;
//
//        root.right = twenty;
//
//        twenty.left = fifteen;
//
//        twenty.right = seven;

        System.out.println ( maxDepth ( root ) );

    }

    static int maxDepthOverall;

    static int maxDepth ( TreeNode root ) {

        if ( root == null ) {

            return 0;

        }

        int currentDepthCount = 1;

        return helper ( root, currentDepthCount );

    }

    static int helper ( TreeNode currentNode, int currentDepthCount ) {

        boolean isLeafNode = currentNode.left == null && currentNode.right == null;

        if ( isLeafNode && currentDepthCount > maxDepthOverall ) {

            maxDepthOverall = currentDepthCount;

            return maxDepthOverall;

        }

        if ( currentNode.left != null ) {

            helper ( currentNode.left, currentDepthCount + 1 );

        }

        if ( currentNode.right != null ) {

            helper ( currentNode.right, currentDepthCount + 1 );

        }


        return maxDepthOverall;

    }

}