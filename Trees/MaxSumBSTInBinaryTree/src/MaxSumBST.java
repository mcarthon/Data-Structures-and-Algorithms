import java.util.HashMap;

public class MaxSumBST {

    public boolean isValid = true;

    public int currentSum = 0;

    public int maxSum = 0;

    public HashMap<TreeNode, Boolean> validateMemo = new HashMap<TreeNode, Boolean>();

    public static void main ( String [] args ) {

//        TreeNode six = new TreeNode ( 6 );
//        TreeNode fourRight = new TreeNode ( 4 );
//        TreeNode five = new TreeNode ( 5, fourRight, six );
//
//        TreeNode twoRight = new TreeNode ( 2 );
//        TreeNode three = new TreeNode ( 3, twoRight, five );
//
//        TreeNode twoLeft = new TreeNode ( 2 );
//        TreeNode fourLeftChild = new TreeNode ( 4 );
//        TreeNode fourLeftParent = new TreeNode ( 4, twoLeft, fourLeftChild );
//
//        TreeNode one = new TreeNode ( 1, fourLeftParent, three );

        TreeNode two = new TreeNode ( 2 );
        TreeNode one = new TreeNode ( 1 );
        TreeNode three = new TreeNode ( 3, one, two );

        TreeNode four = new TreeNode ( 4, three, null );

        MaxSumBST answer = new MaxSumBST();

        System.out.println ( answer.maxSumBST ( four ) );

    }

    public int maxSumBST ( TreeNode root ) {

        if ( root == null ) {

            return this.maxSum;

        }

        if ( this.validateBST ( root ) ) {

            this.sum ( root );

        }

        this.isValid = true;

        this.currentSum = 0;

        this.maxSumBST ( root.left );

        this.maxSumBST ( root.right );

        return this.maxSum;

    }

    public boolean validateBST ( TreeNode root ) {

        if ( root == null ) {

            return this.isValid;

        }

        if ( ! (this.checkBST ( root.left, root.val, "less than" )
                && this.checkBST ( root.right, root.val, "greater than" ) ) ) {

            return this.isValid;

        }

        if ( ! ( this.validateBST ( root.left )
                && this.validateBST ( root.right ) ) ) {

            return this.isValid;

        }

        return this.isValid;

    }

    public boolean checkBST ( TreeNode root, int value, String comparison ) {

        if ( root == null ) {

            return this.isValid;

        }

        if ( comparison.equals ( "less than" ) && root.val >= value
                || comparison.equals ( "greater than" ) && root.val <= value ) {

            this.isValid = false;

            return this.isValid;

        }

        if ( !( this.checkBST ( root.left, value, comparison )
                && this.checkBST ( root.right, value, comparison ) ) ) {

            return this.isValid;

        }

        return this.isValid;

    }

    public void sum ( TreeNode root ) {

        if ( root == null ) {

            return;

        }


        this.currentSum += root.val;

        this.sum ( root.left );

        this.sum ( root.right );

        this.maxSum = Math.max ( this.currentSum, this.maxSum );

    }

}