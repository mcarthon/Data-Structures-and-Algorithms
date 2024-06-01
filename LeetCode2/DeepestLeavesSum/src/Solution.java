import java.util.*;

public class Solution {

    public static void main ( String[] args ) {

        TreeNode seven = new TreeNode ( 7 );
        TreeNode eight = new TreeNode ( 8 );

        TreeNode four = new TreeNode ( 4, seven, null );
        TreeNode five = new TreeNode ( 5, null, null );
        TreeNode six = new TreeNode ( 6, null, eight );

        TreeNode two = new TreeNode ( 2, four, five );
        TreeNode three = new TreeNode ( 3, null, six );

        TreeNode one = new TreeNode ( 1, two, three );

        Solution sl = new Solution();

        System.out.println ( sl.deepestLeavesSum ( one ) );

    }

    public int deepestLeavesSum ( TreeNode root ) {

        Queue<TreeNode> deepestNodes = this.helper ( root );

        return this.sumNodes ( deepestNodes );

    }

    public Queue<TreeNode> helper ( TreeNode root ) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add ( root );

        Queue<TreeNode> deepestNodes = new LinkedList<TreeNode>();

        deepestNodes.add ( root );

        Queue<TreeNode> newQueue = new LinkedList<TreeNode>();

        while ( !queue.isEmpty() ) {

            TreeNode currentNode = queue.poll();

            if ( currentNode.left != null ) {

                newQueue.add ( currentNode.left );

            }

            if ( currentNode.right != null ) {

                newQueue.add ( currentNode.right );

            }

            if ( queue.isEmpty() && !newQueue.isEmpty() ) {

                deepestNodes.clear();

                deepestNodes.addAll ( newQueue );

                queue.addAll ( newQueue );

                newQueue.clear();

            }

        }

        return deepestNodes;

    }

    public int sumNodes ( Queue<TreeNode> deepestNodes ) {

        int sum = 0;

        while ( !deepestNodes.isEmpty() ) {

            TreeNode node = deepestNodes.poll();

            sum += node.val;

        }

        return sum;

    }

}