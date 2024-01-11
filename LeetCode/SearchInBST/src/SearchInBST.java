public class SearchInBST {

    public TreeNode result = null;

    public TreeNode searchBST(TreeNode root, int val) {

        return helper ( root, val );

    }

    public TreeNode helper ( TreeNode currentNode, int val ) {

        if ( currentNode == null ) {

            return this.result;

        }

        if ( currentNode.val == val ) {

            this.result = currentNode;

            return result;

        }

        helper ( currentNode.left, val );

        helper ( currentNode.right, val );

        return this.result;

    }

}
