package Hw3_21000659_DauVanAn.excercise9;

public class CountNumberOfTimes {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(1);
        int searchFor = 1;
        System.out.println("List: " + list);
        System.out.print("Number of element searchFor in list: " + list.getCount(searchFor));
    }
}
