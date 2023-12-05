package Hw7_21000659_DauVanAn.practice5;

public class FindkthSmallest {
    class Node {
        int data;
        Node left;
        Node right;
        int count;
        Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
        Node(int data, int count) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.count = count;
        }
    }

    int count = 0;
    public Node root;
    public void inorder(Node root, int k ,Node curr){
        if( root == null || count >= k ) return;

        inorder(root.left , k , curr);
        count++;
        if(count == k){
            curr.data = root.data;
        }
        inorder(root.right , k , curr );

    }
    public int kthSmallest(Node root, int K) {
        Node curr = new Node(-1);

        inorder(root , K , curr);
        return  curr.data;

    }
    public Node insert(Node node, int key) {
        if (node == null) {
            root = new Node(key, 1);
            return root;
        } else if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            node.count++;
        }
        return node;
    }

    public static void main(String[] args) {
        FindkthSmallest tree = new FindkthSmallest();
        Node root = tree.insert(null, 10);
        tree.insert(root, 3);
        tree.insert(root, 5);
        tree.insert(root, 15);
        tree.insert(root, 8);

        System.out.println(tree.kthSmallest(root, 2));
    }
}
