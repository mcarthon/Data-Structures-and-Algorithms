public class CountNodesEqualToAverageOfSubTree {

    public int sum = 0;

    public int count = 0;

    public int subTreeCount = 0;

    public static void main ( String [] args ) {

        TreeNode zero3 = new TreeNode ( 0 );
        TreeNode zero2 = new TreeNode ( 0 );
        TreeNode zero1 = new TreeNode ( 0, zero2, zero3 );

        CountNodesEqualToAverageOfSubTree countNModes = new CountNodesEqualToAverageOfSubTree();

        System.out.println ( countNModes.averageOfSubtree ( zero1 ) );

    }

    public int averageOfSubtree ( TreeNode root ) {

        return this.helper ( root, 0 );

    }

    public int helper ( TreeNode node, int subTreeCount ) {

        if ( node == null ) {

            return 0;

        }

        this.sum = 0;

        this.count = 0;

        this.calculateAverage ( node );

        int average = this.sum / this.count;

        this.checkValuesInSubTree ( node, average );

        this.helper ( node.left, subTreeCount );

        this.helper ( node.right, subTreeCount );

        return this.subTreeCount;

    }

    public void checkValuesInSubTree ( TreeNode node, int average ) {

        if ( node.val == average ) {

            this.subTreeCount ++;

        }

    }

    public void calculateAverage ( TreeNode node ) {

        if ( node == null ) {

            return;

        }

        this.count ++;

        this.sum += node.val;

        calculateAverage ( node.left );

        calculateAverage ( node.right );

    }

}