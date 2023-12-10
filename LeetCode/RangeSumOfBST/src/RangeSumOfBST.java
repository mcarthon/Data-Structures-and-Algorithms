public class RangeSumOfBST {

    public static void main ( String [] args ) {

        TreeNode root = new TreeNode ( 10 );

        TreeNode five = new TreeNode ( 5 );

        TreeNode fifteen = new TreeNode ( 15 );

        TreeNode three = new TreeNode ( 3 );

        TreeNode seven = new TreeNode ( 7 );

        TreeNode eighteen = new TreeNode ( 18 );

        TreeNode one = new TreeNode ( 1 );

        TreeNode six = new TreeNode ( 6 );

        TreeNode thirteen = new TreeNode ( 13 );

        root.left = five;

        root.right = fifteen;

        five.left = three;

        five.right = seven;

        three.left = one;

        seven.left = six;

        fifteen.left = thirteen;

        fifteen.right = eighteen;

        int low = 6;

        int high = 10;

        System.out.println ( rangeSumBST ( root, low, high ) );

    }

    static int sum = 0;

    static int rangeSumBST ( TreeNode root, int low, int high ) {

        if ( root == null ) {

            return 0;

        }

        if ( root.val >= low && root.val <= high ) {

            sum += root.val;

        }

        rangeSumBST ( root.left, low, high );

        rangeSumBST ( root.right, low, high );

        return sum;

    }

}