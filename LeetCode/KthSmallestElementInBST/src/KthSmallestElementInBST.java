public class KthSmallestElementInBST {

    public int answer;

    public int count = 0;

    public int kthSmallest ( TreeNode root, int k ) {

        return this.helper ( root, k );

    }

    public int helper ( TreeNode currentNode, int k ) {

        if ( currentNode == null ) {

            return this.answer;

        }

        this.helper ( currentNode.left, k );

        this.count ++;

        if ( this.count == k ) {

            this.answer = currentNode.val;

            return this.answer;

        }

        this.helper ( currentNode.right, k );

        return this.answer;

    }

}