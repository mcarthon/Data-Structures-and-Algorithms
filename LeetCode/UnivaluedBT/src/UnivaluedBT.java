public class UnivaluedBT {

    public boolean isUniValue = true;

    public boolean isUnivalTree ( TreeNode root ) {

        return this.helper ( root, root.val );

    }

    public boolean helper ( TreeNode currentNode, int value ) {

        if ( currentNode == null ) {

            return this.isUniValue;

        }

        if ( currentNode.val != value ) {

            this.isUniValue = false;

            return this.isUniValue;

        }

        if ( !this.helper ( currentNode.left, value )
                || !this.helper ( currentNode.right, value ) ) {

            this.isUniValue = false;

            return this.isUniValue;

        }

        return this.isUniValue;

    }

}