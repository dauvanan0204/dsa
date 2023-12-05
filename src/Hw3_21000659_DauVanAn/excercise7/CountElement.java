package Hw3_21000659_DauVanAn.excercise7;

public class CountElement {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("List: " + list);
        System.out.print("Number of element in list: " + list.getCount());
    }
}
