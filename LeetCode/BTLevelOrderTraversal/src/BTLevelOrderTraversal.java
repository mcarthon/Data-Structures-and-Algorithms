import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {

    public static void main ( String [] args ) {

        TreeNode seven = new TreeNode ( 7 );
        TreeNode fifteen = new TreeNode ( 15 );

        TreeNode twenty = new TreeNode ( 20, fifteen, seven );
        TreeNode nine = new TreeNode ( 9 );

        TreeNode three = new TreeNode ( 3, nine, twenty );

        BTLevelOrderTraversal bt = new BTLevelOrderTraversal();

        bt.levelOrder ( three );

    }

    public List<List<Integer>> levelOrder (TreeNode root ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if ( root == null ) {

            return result;

        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add ( root );

        while ( !queue.isEmpty() ) {

            List<Integer> currentLevel = new ArrayList<Integer>();

            Queue<TreeNode> newQueue = new LinkedList<TreeNode>();

            while ( !queue.isEmpty() ) {

                TreeNode node = queue.poll();

                currentLevel.add ( node.val );

                if ( node.left != null ) {

                    newQueue.add ( node.left );

                }

                if ( node.right != null ) {

                    newQueue.add ( node.right );

                }

            }

            result.add ( currentLevel );

            queue.addAll ( newQueue );

        }

        return result;

    }

}