package Hw8_21000659_DauVanAn.excercise4;
public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Đồ thị có hướng được biểu diễn bằng ma trận trọng số
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int startVertex = 0; // Đỉnh xuất phát
        int endVertex = 4;   // Đỉnh đích

        dijkstra(graph, startVertex, endVertex);
    }

    private static void dijkstra(int[][] graph, int start, int end) {
        int vertices = graph.length;
        int[] dist = new int[vertices]; // Lưu trữ khoảng cách ngắn nhất từ đỉnh xuất phát đến các đỉnh khác
        boolean[] visited = new boolean[vertices]; // Đánh dấu các đỉnh đã được duyệt

        // Khởi tạo khoảng cách và đánh dấu các đỉnh chưa được duyệt
        for (int i = 0; i < vertices; i++) {
            dist[i] = INF;
            visited[i] = false;
        }

        // Khoảng cách từ đỉnh xuất phát đến chính nó là 0
        dist[start] = 0;

        // Tìm đường đi ngắn nhất
        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // In đường đi ngắn nhất từ đỉnh xuất phát đến đỉnh đích
        System.out.println("Shortest Path from " + start + " to " + end + ": " + dist[end]);
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}

