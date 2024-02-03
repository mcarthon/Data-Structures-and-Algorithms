public class SecondMinBST {

    public int count = 0;

    public int min = 0;

    public int answer = 0;

    public int findSecondMinimumValue ( TreeNode root ) {

        if ( root == null ) {

            return this.count;

        }

        this.findSecondMinimumValue ( root.left );

        this.count ++;

        int newMin = root.val;

        if ( this.count == 1 ) {

            this.min = root.val;

        }

        if ( this.count > 1 ) {

            if ( newMin > this.min ) {

                this.answer = newMin;

            }

            return this.answer;

        }

        this.findSecondMinimumValue ( root.right );

        return this.answer;

    }

}