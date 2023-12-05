package Hw7_21000659_DauVanAn.excercise1.simplearraylist;

import java.util.Iterator;

public class TestSimpleArrayList {
    public static void main(String[] args) {
        ListInterface<Integer> list = new SimpleArrayList<>();
        // add element to list
        list.add(5);                // list: [5]
        list.add(3);                // list: [5, 3]
        list.add(6);                // list: [5, 3, 6]
        list.add(null);             // list: [5, 3, 6, null]
        System.out.println("Element in list: " + list);   // list: [5, 3, 6, null]
        // Test set method
        Integer integer = null;
        list.set(1, integer);       // list: [5, null, 6, null]
        // Test remove method
        list.remove(integer);       // list: [5, 6, null]
        System.out.println("Element in list: " + list);   // list: [5, 6, null]
        // Test size method
        System.out.println("Number element of list:  "+ list.size()); // size = 3
        // Test get method
        System.out.println("Second element in list: " + list.get(1)); // 5
        // Test contain method
        list.isContain(5);          // 5 is contained in the list.
        // Test iterator method
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + " ");
        }
        // Test isEmpty method
        System.out.println();
        System.out.println(list.isEmpty()); // false
    }
}
