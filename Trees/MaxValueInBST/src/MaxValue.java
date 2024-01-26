public class MaxValue {

    static Integer get_maximum_value ( BinaryTreeNode root ) {

        return root.right == null? root.value : get_maximum_value ( root.right );

    }

}