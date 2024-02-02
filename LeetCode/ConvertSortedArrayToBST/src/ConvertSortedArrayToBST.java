public class ConvertSortedArrayToBST {

    public static void main ( String [] args ) {

        int[] nums = { -10, -3, 0, 5, 9 };

        ConvertSortedArrayToBST c = new ConvertSortedArrayToBST();

        c.sortedArrayToBST ( nums );

    }

    public TreeNode sortedArrayToBST ( int[] nums ) {

        return this.helper ( 0, nums.length - 1, nums );

    }

    public TreeNode helper ( int start, int end, int [] nums ) {

        if ( start > end ) {

            return null;

        }

        int half = start + ( end - start ) / 2;

        TreeNode root = new TreeNode ( nums [ half ] );

        root.left = this.helper ( start, half - 1, nums );

        root.right = this.helper ( half + 1, end, nums );

        return root;

    }

}