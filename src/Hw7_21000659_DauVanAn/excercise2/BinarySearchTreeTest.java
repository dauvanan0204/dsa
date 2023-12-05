package Hw7_21000659_DauVanAn.excercise2;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTreeTest test = new BinarySearchTreeTest();
        test.runTests();
    }

    public void runTests() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // Test findMin when the tree is empty
        System.out.println("Minimum element in an empty tree: " + binarySearchTree.findMin(null));

        // Test insert and search
        TreeNode root = binarySearchTree.insert(null, 10);
        binarySearchTree.insert(root, 3);
        binarySearchTree.insert(root, 5);
        binarySearchTree.insert(root, 15);
        binarySearchTree.insert(root, 3);
        binarySearchTree.insert(root, 8);
        // Test findMin
        System.out.println("Minimum element in the tree: " + binarySearchTree.findMin(root));

        // Test search
        int keyToSearch = 5;
        TreeNode foundNode = binarySearchTree.search(root, keyToSearch);
        System.out.println("Search for key " + keyToSearch + ": " + (foundNode != null ? "Found" : "Not Found"));

        // Test delete
        int keyToDelete = 3;
        root = binarySearchTree.delete(root, keyToDelete);
        System.out.println("After deleting key " + keyToDelete + ", minimum element: " + binarySearchTree.findMin(root));

        // Test search after deletion
        foundNode = binarySearchTree.search(root, keyToDelete);
        System.out.println("Search for key " + keyToDelete + " after deletion: " + (foundNode != null ? "Found" : "Not Found"));

        root = binarySearchTree.delete(root, keyToDelete);
        System.out.println("After deleting key " + keyToDelete + ", minimum element: " + binarySearchTree.findMin(root));

        foundNode = binarySearchTree.search(root, keyToDelete);
        System.out.println("Search for key " + keyToDelete + " after deletion: " + (foundNode != null ? "Found" : "Not Found"));
    }
}

