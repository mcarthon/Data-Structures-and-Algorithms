import java.util.ArrayList;
import java.util.List;

public class SecondMinBT {

    public static void main ( String [] args ) {

//        TreeNode seven = new TreeNode(7);
//        TreeNode fiveLeaf = new TreeNode(5);
//
//        TreeNode two = new TreeNode(2);
//        TreeNode five = new TreeNode(5, fiveLeaf, seven);
//
//        TreeNode twoRoot = new TreeNode(2, two, five);

        TreeNode fiveLeaf = new TreeNode (5 );
        TreeNode eight = new TreeNode ( 8 );

        TreeNode five = new TreeNode (5, eight, fiveLeaf );

        SecondMinBT sm = new SecondMinBT();

        System.out.println(sm.findSecondMinimumValue ( five ) );

    }

    public List<Integer> twoSmallestNums = new ArrayList<Integer>();

    public int findSecondMinimumValue ( TreeNode root ) {

        this.helper ( root );

        return this.twoSmallestNums.size() > 1 ? Math.max ( this.twoSmallestNums.get ( 0 ), this.twoSmallestNums.get ( 1 ) ) : -1;

    }

    public void helper ( TreeNode root ) {

        if ( root == null ) {

            return;

        }

        if ( this.twoSmallestNums.isEmpty() ) {

            this.twoSmallestNums.add ( root.val );

        }

        if ( this.twoSmallestNums.size() < 2 && root.val != this.twoSmallestNums.get ( 0 ) ) {

            this.twoSmallestNums.add ( root.val );

        }

        if ( this.twoSmallestNums.size() == 2 ) {

            int max = Math.max ( this.twoSmallestNums.get ( 0 ), this.twoSmallestNums.get ( 1 ) );

            int min = Math.min ( this.twoSmallestNums.get ( 0 ), this.twoSmallestNums.get ( 1 ) );

            if ( root.val < max && root.val > min ) {

                if ( max == this.twoSmallestNums.get(0)) {

                    this.twoSmallestNums.set(0, root.val);

                }

                else {

                    this.twoSmallestNums.set(1, root.val);

                }

            }

        }

        this.helper ( root.left );

        this.helper ( root.right );

    }

}