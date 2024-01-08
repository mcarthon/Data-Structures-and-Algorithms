import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AllElementsInTwoBST {

    public static void main ( String [] args ) {

        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, four);

        TreeNode three = new TreeNode(3);
        TreeNode zero = new TreeNode(0);
        TreeNode one1 = new TreeNode(2, zero, three);

        System.out.println ( getAll ( two, one1 ) );

    }

    static List<Integer> getAll ( TreeNode root1, TreeNode root2 ) {

        List<Integer> allNodes = new ArrayList<Integer>();

        getAllNodes ( root1, allNodes );

        getAllNodes ( root2, allNodes );

        allNodes.sort(Comparator.comparingInt(a -> a));

        return allNodes;

    }

    static void getAllNodes ( TreeNode node, List<Integer> allNodes ) {

        if ( node == null ) {

            return;

        }

        allNodes.add ( node.val );

        getAllNodes ( node.left, allNodes );

        getAllNodes ( node.right, allNodes );

    }

}
