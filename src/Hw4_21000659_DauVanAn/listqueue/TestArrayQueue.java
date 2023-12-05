package Hw4_21000659_DauVanAn.listqueue;

import java.util.Iterator;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.dequeue();
        printQueue(queue);

        System.out.println();
        System.out.println(queue.first());

    }
    public static void printQueue(ArrayQueue<Integer> queue) {
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.print(num + " ");
        }
    }
}
