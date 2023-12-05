package midterm;

public class Robot {
    public static int countPath(int M, int N, int t) {
        int count = 0;
        if (M == 1 && N == 1) {
            return 1;
        }
        int[][] dp = new int[M+1][N+1];

        // Khởi tạo ma trận
        for(int i = 1; i < M + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                dp[i][j] = 1;
            }
        }

        // Đặt giá trị ban đầu
        dp[1][t] = 1;
        dp[1][t+1] = 1;

        // Tính toán số đường đi cho mỗi ô t
        for(int i = 1; i < t; i++) {
            count += dp[1][i];
        }

        for(int i = 2; i < M + 1; i++) {
            count += dp[i][M];
        }
//        System.out.println(count);

        // Tính toán số đường đi cho mỗi ô t + 1
        for(int i = t + 2; i < N + 1; i++) {
            count += dp[1][i];
        }

        for(int i = 2; i < M + 1; i++) {
            count += dp[i][M];
        }
//        System.out.println(count);

//        for (int i = 1; i < M + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        // Trả về tổng số đường đi đến cửa
        return count;
    }
    public static void main(String[] args) {
        int M = 5;
        int N = 6;
        int t = 2;
//        printMatrix(M, N, t);
        System.out.println(countPath(M, N, t)); // Kết quả: 8
    }

    public static void printMatrix(int m, int n, int t) {
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = 0;
            }
        }
        arr[1][t] = 1;
        arr[1][t+1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
