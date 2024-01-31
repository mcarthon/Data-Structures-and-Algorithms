public class UpsideDownCake {

    public TreeNode newHead;

    public TreeNode upsideDownBinaryTree ( TreeNode root ) {

        if ( root == null || root.left == null ) {

            return root;

        }

        return this.helper ( root, root.left );

    }

    public TreeNode helper ( TreeNode previousNode, TreeNode currentNode ) {

        if ( currentNode.left == null ) {

            this.newHead = currentNode;

            currentNode.right = previousNode;

            currentNode.left = previousNode.right;

            previousNode.left = null;

            previousNode.right = null;

            return newHead;

        }

        this.helper ( currentNode, currentNode.left );

        currentNode.right = previousNode;

        currentNode.left = previousNode.right;

        previousNode.left = null;

        previousNode.right = null;

        return newHead;

    }

}