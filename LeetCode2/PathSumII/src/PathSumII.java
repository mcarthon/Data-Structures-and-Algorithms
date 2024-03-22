import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum ( TreeNode root, int targetSum ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if ( root == null ) {

            return result;

        }

        List<TreeNode> visited = new ArrayList<TreeNode>();

        return this.helper ( root,
                             new ArrayList<Integer>(),
                             0,
                             targetSum,
                             visited,
                             result );

    }

    public List<List<Integer>> helper ( TreeNode currentNode,
                                        List<Integer> currentPath,
                                        int currentSum,
                                        int targetSum,
                                        List<TreeNode> visited,
                                        List<List<Integer>> result ) {

        int newSum = currentSum + currentNode.val;

        List<Integer> newPath = new ArrayList<Integer> ( currentPath );

        newPath.add ( currentNode.val );

        if ( currentNode.left == null && currentNode.right == null ) {

            if ( newSum == targetSum && !visited.contains ( currentNode ) ) {

                visited.add ( currentNode );

                result.add ( new ArrayList<Integer> ( newPath ) );

            }

            return result;

        }

        if ( currentNode.left != null ) {

            this.helper ( currentNode.left, newPath, newSum, targetSum, visited, result );

        }

        if ( currentNode.right != null ) {

            this.helper ( currentNode.right, newPath, newSum, targetSum, visited, result );

        }

        return result;

    }

}