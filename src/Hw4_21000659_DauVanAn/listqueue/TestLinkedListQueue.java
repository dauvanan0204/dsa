package Hw4_21000659_DauVanAn.listqueue;

import java.util.Iterator;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        printQueue(queue);
        queue.dequeue();
        System.out.println();
        printQueue(queue);
    }
    public static void printQueue(LinkedListQueue<Integer> queue) {
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.print(num + " ");
        }
    }
}
