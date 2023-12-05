package Hw3_21000659_DauVanAn.codelearn;

public class CircularLinkedList {
    Node head;

    public void addToEmpty(int data) {
        if (head != null)
            return;

        Node newNode = new Node(data);
        newNode.next = newNode;
        head = newNode;
    }

    public void addToEnd(int data) {
        if (head == null) {
            addToEmpty(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head; // Thêm vào cuối danh sách

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode; // Cập nhật liên kết

    }

    public void printCircularListFromK(int k) {
        if (head == null)
            return;

        Node current = head;
        for (int i = 0; i < k; i++) {
            current = current.next;
        }

        Node start = current;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == start)
                break;
        }
    }
}


