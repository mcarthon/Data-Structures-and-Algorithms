public class DeleteNodeInBST {

    public static void main ( String [] args ) {

        TreeNode nine = new TreeNode ( 9 );
        TreeNode eight = new TreeNode ( 8, null, nine );

        TreeNode five = new TreeNode ( 5 );
        TreeNode six = new TreeNode ( 6, five, null );

        TreeNode seven = new TreeNode ( 7, six, eight );

        TreeNode four = new TreeNode ( 4, null, seven );

        DeleteNodeInBST cass = new DeleteNodeInBST();

        cass.deleteNode ( four, 7 );

    }

    public TreeNode deleteNode ( TreeNode root, int key ) {

        return this.searchAndDestroy ( null, root, root, key );

    }

    public TreeNode searchAndDestroy ( TreeNode previous, TreeNode currentNode, TreeNode root, int key ) {

        if ( currentNode == null ) {

            return root;

        }

        if ( currentNode.val == key ) {

            if ( currentNode.left == null && currentNode.right == null ) {

                root = this.noChildren ( previous, currentNode, root );

            }

            else if ( currentNode.left == null || currentNode.right == null ) {

                root = this.oneChild ( previous, currentNode, root );

            }

            else {

                this.twoChildren ( currentNode, currentNode, currentNode.left );

            }

        }

        else if ( key < currentNode.val ) {

            this.searchAndDestroy ( currentNode, currentNode.left, root, key );

        }

        else {

            this.searchAndDestroy ( currentNode, currentNode.right, root, key );

        }

        return root;

    }

    public TreeNode noChildren ( TreeNode previous, TreeNode currentNode, TreeNode root ) {

        if ( previous == null ) {

            return previous;

        }

        if ( currentNode.val < previous.val ) {

            previous.left = null;

        }

        else {

            previous.right = null;

        }

        return root;

    }

    public TreeNode oneChild ( TreeNode previous, TreeNode currentNode, TreeNode root ) {

        if ( previous == null ) {

            if ( currentNode.left != null ) {

                return currentNode.left;

            }

            else {

                return currentNode.right;

            }

        }

        else {

            if ( currentNode.val < previous.val ) {

                if ( currentNode.left != null ) {

                    previous.left = currentNode.left;

                }

                else {

                    previous.left = currentNode.right;

                }

            }

            else {

                if ( currentNode.left != null ) {

                    previous.right = currentNode.left;

                }

                else {

                    previous.right = currentNode.right;

                }

            }

        }

        return root;

    }

    public void twoChildren ( TreeNode rootOfSubTree, TreeNode previous, TreeNode predecessor ) {

        if ( predecessor.right == null ) {

            int value = predecessor.val;

            if ( predecessor.val < previous.val ) {

                if ( predecessor.left != null ) {

                    previous.left = predecessor.left;

                }

                else if ( predecessor.right != null ) {

                    previous.left = predecessor.right;

                }

                else {

                    previous.left = null;

                }

            }

            else {

                if ( predecessor.left != null ) {

                    previous.right = predecessor.left;

                }

                else if ( predecessor.right != null ) {

                    previous.right = predecessor.right;

                }

                else {

                    previous.right = null;

                }

            }

            rootOfSubTree.val = value;

            return;

        }

        this.twoChildren ( rootOfSubTree, predecessor, predecessor.right );

    }

}