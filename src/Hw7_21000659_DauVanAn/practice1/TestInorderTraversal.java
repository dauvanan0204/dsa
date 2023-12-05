package Hw7_21000659_DauVanAn.practice1;

public class TestInorderTraversal {
    public static void main(String[] args) {
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        System.out.println(isRepresentingBST(arr, size));
    }
    public static int isRepresentingBST(int arr[], int N) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i+1]) return 0;
        }
        return 1;
    }
}

