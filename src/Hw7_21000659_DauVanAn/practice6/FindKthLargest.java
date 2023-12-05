package Hw7_21000659_DauVanAn.practice6;

public class FindKthLargest {
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
    public void inorder(Node root, int k , Node curr){

        if( root == null || count >= k ) return;


        inorder(root.right , k , curr);
        count++;
        if(count == k){
            curr.data = root.data;
        }
        inorder(root.left , k , curr );

    }
    public int kthLargest(Node root,int K) {
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
        FindKthLargest tree = new FindKthLargest();
        Node root = tree.insert(null, 10);
        tree.insert(root, 3);
        tree.insert(root, 5);
        tree.insert(root, 15);
        tree.insert(root, 8);

        System.out.println(tree.kthLargest(root, 2));
    }
}
