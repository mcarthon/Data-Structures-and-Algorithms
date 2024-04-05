public class BinarySearchTree {

    public BSTNode search ( BSTNode root, int value ) {

        if ( root == null ) {

            return root;

        }

        return this.searchHelper ( root, value );

    }

    public BSTNode searchHelper ( BSTNode currentNode, int value ) {

        if ( currentNode == null ) {

            return null;

        }

        if ( currentNode.value == value ) {

            return currentNode;

        }

        if ( value < currentNode.value ) {

            return this.searchHelper ( currentNode.left, value );

        }

        if ( value > currentNode.value ) {

            return this.searchHelper ( currentNode.right, value );

        }

        return null;

    }

    public BSTNode insertNode ( BSTNode root, int value ) {

        if ( root == null ) {

            BSTNode newNode = new BSTNode ( value );

            return newNode;

        }

        return this.insertNodeHelper ( root, root, value );

    }

    public BSTNode insertNodeHelper ( BSTNode root, BSTNode currentNode, int valueToInsert ) {

        if ( valueToInsert < currentNode.value ) {

            if ( currentNode.left != null ) {

                return this.insertNodeHelper ( root, currentNode.left, valueToInsert );

            }

            else {

                BSTNode newNode = new BSTNode ( valueToInsert );

                currentNode.left = newNode;

                return root;

            }

        }

        else if ( valueToInsert > currentNode.value ) {

            if ( currentNode.right != null ) {

                return this.insertNodeHelper ( root, currentNode.right, valueToInsert );

            }

            else {

                BSTNode newNode = new BSTNode ( valueToInsert );

                currentNode.right = newNode;

                return root;

            }

        }

        return root;

    }

    public BSTNode deleteNode ( BSTNode root, int valueToDelete ) {

        if ( root == null ) {

            return root;

        }

        return this.deleteHelper ( root, null, root, valueToDelete );

    }

    public BSTNode deleteHelper ( BSTNode root, BSTNode previous, BSTNode currentNode, int valueToDelete ) {

        if ( currentNode == null ) {

            return root;

        }

        if ( currentNode.value == valueToDelete ) {

            if ( currentNode.left == null && currentNode.right == null ) {

                return this.noChildrenDelete ( root, previous, currentNode );

            }

            else if ( currentNode.left == null || currentNode.right == null ) {

                return this.oneChildDelete ( root, previous, currentNode );

            }

            else {

                return this.twoChildrenDelete ( root, currentNode, currentNode, currentNode.left );

            }

        }

        else {

            if ( valueToDelete < currentNode.value ) {

                return this.deleteHelper ( root, currentNode, currentNode.left, valueToDelete );

            }

            else {

                return this.deleteHelper ( root, currentNode, currentNode.right, valueToDelete );

            }

        }

    }

    public BSTNode noChildrenDelete ( BSTNode root, BSTNode previous, BSTNode nodeToDelete ) {

        if ( previous == null ) {

            return previous;

        }

        if ( nodeToDelete.value < previous.value ) {

            previous.left = null;

        }

        else {

            previous.right = null;

        }

        return root;

    }

    public BSTNode oneChildDelete ( BSTNode root, BSTNode previous, BSTNode nodeToDelete ) {

        if ( previous == null ) {

            if ( nodeToDelete.left != null ) {

                return nodeToDelete.left;

            }

            if ( nodeToDelete.right != null ) {

                return nodeToDelete.right;

            }

        }

        if ( nodeToDelete.value < previous.value ) {

            if ( nodeToDelete.left != null ) {

                previous.left = nodeToDelete.left;

            }

            if ( nodeToDelete.right != null ) {

                previous.left = nodeToDelete.right;

            }

        }

        else {

            if ( nodeToDelete.left != null ) {

                previous.right = nodeToDelete.left;

            }

            if ( nodeToDelete.right != null ) {

                previous.right = nodeToDelete.right;

            }

        }

        return root;

    }

    public BSTNode twoChildrenDelete ( BSTNode root, BSTNode rootOfSubtree, BSTNode previous, BSTNode predecessor ) {

        while ( predecessor.right != null ) {

            previous = predecessor;

            predecessor = predecessor.right;

        }

        if ( predecessor.value < previous.value ) {

            previous.left = predecessor.left;

        }

        else {

            previous.right = predecessor.left;

        }

        return root;

    }

    public BSTNode findPredecessor ( BSTNode root, BSTNode node ) {

        BSTNode predecessor = null;

        if ( node.left != null ) {

            predecessor = node.left;

            while ( predecessor.right != null ) {

                predecessor = predecessor.right;

            }

            return predecessor;

        }

        BSTNode runner = root;

        while ( runner.value != node.value ) {

            if ( node.value < runner.value ) {

                runner = runner.left;

            }

            else {

                predecessor = runner;

                runner = runner.right;

            }

        }

        return predecessor;

    }

    public BSTNode findSuccessor ( BSTNode root, BSTNode node ) {

        BSTNode successor = null;

        if ( node.right != null ) {

            successor = node.right;

            while ( successor.left != null ) {

                successor = successor.left;

            }

            return successor;

        }

        else {

            BSTNode runner = root;

            while ( runner.value != node.value ) {

                if ( node.value < runner.value ) {

                    successor = runner;

                    runner = runner.left;

                }

                else {

                    runner = runner.right;

                }

            }

        }

        return successor;

    }

}