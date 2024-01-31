public class CountUnivalueSubtrees {

    public int count = 0;

    public boolean isUnivalued = true;

    public int countUnivalSubtrees ( TreeNode root ) {

        if ( root == null ) {

            return this.count;

        }

        count += this.checkUnivalue ( root, root.val ) ? 1 : 0;

        this.isUnivalued = true;

        this.countUnivalSubtrees ( root.left );

        this.countUnivalSubtrees ( root.right );

        return this.count;

    }

    public boolean checkUnivalue ( TreeNode node, int value ) {

        if ( node == null ) {

            return this.isUnivalued;

        }

        if ( node.val != value ) {

            this.isUnivalued = false;

            return this.isUnivalued;

        }

        if ( !this.checkUnivalue ( node.left, value )
                || !this.checkUnivalue ( node.right, value ) ) {

            return this.isUnivalued;

        }

        return this.isUnivalued;

    }

}