public class PathSum {

    static boolean isTargetSum = false;

    public static void main ( String [] args ) {

//        TreeNode seven = new TreeNode ( 7 );
//        TreeNode two = new TreeNode ( 7 );
//        TreeNode one = new TreeNode ( 7 );
//
//        TreeNode eleven = new TreeNode ( 11, seven, two );
//        TreeNode thirteen = new TreeNode ( 13 );
//        TreeNode four = new TreeNode ( 4, null, one );
//
//        TreeNode fourHigh = new TreeNode ( 4, eleven, null );
//        TreeNode eight = new TreeNode ( 8, thirteen, four );
//
//        TreeNode five = new TreeNode ( 5, fourHigh, eight );

//        System.out.println ( hasPathSum ( five, 22 ) );

        TreeNode root = new TreeNode ( 1, new TreeNode ( 2 ), null );

        System.out.println ( hasPathSum ( root, 2 ) );

    }

    static boolean hasPathSum ( TreeNode root, int targetSum ) {

        if ( root != null ) {

            return helper ( root, 0, targetSum );

        }

        return isTargetSum;

    }

    static boolean helper ( TreeNode currentNode, int currentPathSum, int targetSum ) {

        if ( currentNode == null ) {

            return isTargetSum;

        }

        if ( currentNode.left == null && currentNode.right == null ) {

            if ( currentPathSum + currentNode.val == targetSum ) {

                isTargetSum = true;

            }

            return isTargetSum;

        }

        helper ( currentNode.left, currentPathSum + currentNode.val, targetSum );

        helper ( currentNode.right, currentPathSum + currentNode.val, targetSum );

        return isTargetSum;

    }

}