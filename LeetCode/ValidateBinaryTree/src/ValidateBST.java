import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public static void main ( String [] args ) {

    }

    public boolean isValid = true;

    public boolean isValidBST ( TreeNode root ) {

        return this.helper ( root );

    }

    public boolean helper ( TreeNode node ) {

        if ( node == null ) {

            return this.isValid;

        }

        if ( !( this.checkValues ( node.left, node.val, "lesser" )
                && this.checkValues ( node.right, node.val, "greater" ) ) ) {

            this.isValid = false;

            return this.isValid;

        }

        this.helper ( node.left );

        this.helper ( node.right );

        return this.isValid;

    }

    public boolean checkValues ( TreeNode node, int val, String comparison ) {

        if ( node == null ) {

            return this.isValid;

        }

        if ( comparison == "greater" && node.val <= val ) {

            this.isValid = false;

            return this.isValid;

        }

        if ( comparison == "lesser" && node.val >= val ) {

            this.isValid = false;

            return this.isValid;

        }

        if ( !this.checkValues ( node.left, val, comparison ) ) {

            this.isValid = false;

            return this.isValid;

        }

        if ( !this.checkValues ( node.right, val, comparison ) ) {

            this.isValid = false;

            return this.isValid;

        }

        return this.isValid;

    }

}