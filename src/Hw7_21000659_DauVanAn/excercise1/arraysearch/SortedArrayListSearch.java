package Hw7_21000659_DauVanAn.excercise1.arraysearch;
import Hw7_21000659_DauVanAn.excercise1.simplearraylist.SimpleArrayList;
public class SortedArrayListSearch {
    public static <T extends Comparable<T>> int binarySearchSorted(SimpleArrayList<T> list, T target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = target.compareTo(list.get(mid));

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public static <T> int linearSearchSorted(SimpleArrayList<T> array, T target) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SimpleArrayList<Integer> arrayList = new SimpleArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(binarySearchSorted(arrayList, 4));
        System.out.println(linearSearchSorted(arrayList, 4));
    }
}
