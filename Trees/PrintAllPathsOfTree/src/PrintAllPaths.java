import java.util.ArrayList;

public class PrintAllPaths {

    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree (BinaryTreeNode root ) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> currentPath = new ArrayList<Integer>();

        return helper ( root, currentPath, result );

    }

    static ArrayList<ArrayList<Integer>> helper ( BinaryTreeNode currentNode,
                                                  ArrayList<Integer> currentPath,
                                                  ArrayList<ArrayList<Integer>> result ) {

        if ( currentNode == null ) {

            return result;

        }

        if ( currentNode.left == null && currentNode.right == null ) {

            currentPath.add ( currentNode.value );

            result.add ( new ArrayList<Integer> ( currentPath ) );

            return result;

        }

        currentPath.add ( currentNode.value );

        helper ( currentNode.left, new ArrayList<Integer> ( currentPath ), result );

        helper ( currentNode.right, new ArrayList<Integer> ( currentPath ), result );

        return result;

    }

}