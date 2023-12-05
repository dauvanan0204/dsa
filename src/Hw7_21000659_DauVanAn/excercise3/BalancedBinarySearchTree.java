package Hw7_21000659_DauVanAn.excercise3;

public class BalancedBinarySearchTree {
    public AVLNode root;

    public BalancedBinarySearchTree() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = insert(this.root, key);
    }

    private AVLNode insert(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.getItem()) {
            node.left = insert(node.left, key);
        } else if (key > node.item) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate key, update count or handle as needed
            node.count++;
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check balance factor and perform rotations if necessary
        int balance = getBalance(node);

        // Left Heavy
        if (balance > 1) {
            if (key < node.left.item) {
                return rightRotate(node);
            } else {
                return leftRightRotate(node);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (key > node.right.item) {
                return leftRotate(node);
            } else {
                return rightLeftRotate(node);
            }
        }

        return node;
    }

    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Return new root
        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return y;
    }

    private AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    private AVLNode rightLeftRotate(AVLNode z) {
        z.right = rightRotate(z.right);
        return leftRotate(z);
    }
    public void delete(int key) {
        root = delete(root, key);
    }
    public AVLNode delete(AVLNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.getItem()) {
            root.setLeft(delete(root.getLeft(), key));
        } else if (key > root.getItem()) {
            root.setRight(delete(root.getRight(), key));
        } else {
            // Node with only one child or no child
            if (root.getLeft() == null || root.getRight() == null) {
                AVLNode temp = (root.getLeft() != null) ? root.getLeft() : root.getRight();

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with two children: Get the inorder successor (smallest
                // in the right subtree)
                AVLNode temp = findMin(root.getRight());

                // Copy the inorder successor's data to this node
                root.setItem(temp.getItem());

                // Delete the inorder successor
                root.setRight(delete(root.getRight(), temp.getItem()));
            }
        }

        // If the tree had only one node, then return
        if (root == null) {
            return root;
        }

        // Update height of the current node
        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

        // Get the balance factor of this node to check whether it became unbalanced
        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.getLeft()) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.getRight()) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    private AVLNode findMin(AVLNode node) {
        if (node == null) {
            return null;
        }

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }
    public int findMin() {
        if (root == null) {
            System.out.println("The tree is empty");
            return Integer.MIN_VALUE;
        }

        AVLNode minNode = findMin(root);

        return minNode.getItem();
    }
    public AVLNode search(int key) {
        return search(root, key);
    }
    public AVLNode search(AVLNode root, int key) {
        if (root == null || root.getItem() == key) {
            return root;
        }

        if (key < root.getItem()) {
            return search(root.getLeft(), key);
        }

        return search(root.getRight(), key);
    }
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(AVLNode node, int level) {
        if (node != null) {
            printTree(node.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }

            System.out.println(node.getItem() + " (" + node.getBalanceFactor() + ")");

            printTree(node.getLeft(), level + 1);
        }
    }

    // AVLNode class definition

    public static void main(String[] args) {
        BalancedBinarySearchTree avlTree = new BalancedBinarySearchTree();

        // Insert some values
        avlTree.insert(30);
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(10);
        avlTree.insert(25);

        // Display the AVL tree
        System.out.println("AVL Tree after insertions:");
        avlTree.printTree();

        // Search for a value
        int searchValue = 20;
        AVLNode searchResult = avlTree.search(searchValue);
        if (searchResult != null) {
            System.out.println("Found value " + searchValue + " in the tree.");
        } else {
            System.out.println("Value " + searchValue + " not found in the tree.");
        }

        // Delete a value
        int deleteValue = 30;
        avlTree.delete(deleteValue);

        // Display the AVL tree after deletion
        System.out.println("\nAVL Tree after deletion of " + deleteValue + ":");
        avlTree.printTree();
    }
}
