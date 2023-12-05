package Hw3_21000659_DauVanAn.codelearn;

import java.util.Scanner;
public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}


