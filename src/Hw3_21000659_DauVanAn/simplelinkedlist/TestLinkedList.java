package Hw3_21000659_DauVanAn.simplelinkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        // Test add method
        list.add(2);                // list: [2]
        list.add(5);                // list: [2, 5]
        list.addBot(4);        // list: [2, 5, 4]
        // Test set method
        list.set(2, 1);             // list: [2, 5, 1]
        System.out.println("Element in list: " + list);   // list: [2, 5, 1]
        // Test get method
        System.out.println("Element 2th of list: " + list.get(1)); // 5
        // Test removeBot method
        list.removeBot();              // list: [2, 5]
        System.out.println("Element in list: " + list); // list: [2, 5]
        // Test removeTop method
        list.removeTop();               // list: [5]
        System.out.println("Element in list: " + list);       // list: [5]
        list.add(7);                    // list: [5, 7]
        // Test remove method
        list.remove(7);             // list: [5]
        // Test isContain method
        System.out.println(list.isContain(6)); //false
    }
}
