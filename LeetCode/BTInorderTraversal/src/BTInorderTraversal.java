import java.util.ArrayList;
import java.util.List;

public class BTInorderTraversal {

    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> inorderTraversal ( TreeNode root ) {

        if ( root == null ) {

            return result;

        }

        this.inorderTraversal ( root.left );

        this.result.add ( root.val );

        this.inorderTraversal ( root.right );

        return this.result;

    }

}