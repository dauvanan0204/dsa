package hackerrank.day;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int key = 4;
        System.out.println(interpolationSearch(arr, arr.length, key));
    }
    public static int interpolationSearch(int[] arr, int size, int key) {
        int low = 0;
        int high = size - 1;
        int mid;
        while ((arr[high] != arr[low]) && (key >= arr[low]) && (key <= arr[high])) {
            mid = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if (key == arr[low]) {
            return low;
        } else {
            return -1;
        }
    }
}
