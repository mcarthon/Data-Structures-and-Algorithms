public class TreeNode {

    int val;

    TreeNode right;

    TreeNode left;

    TreeNode () {};

    TreeNode ( int val ) {

        this.val = val;

    }

    TreeNode ( int val, TreeNode left, TreeNode right ) {

        this.val = val;

        this.right = right;

        this.left = left;
        
    }

}