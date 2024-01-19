public class InvertBinaryTree {

    public TreeNode invertTree ( TreeNode root ) {

        if ( root == null ) {

            return root;

        }

        swapChildren ( root );

        invertTree ( root.left );

        invertTree ( root.right );

        return root;

    }

    public void swapChildren ( TreeNode node ) {

        TreeNode left = node.left;

        node.left = node.right;

        node.right = left;

    }

}