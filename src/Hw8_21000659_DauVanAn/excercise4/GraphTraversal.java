package Hw8_21000659_DauVanAn.excercise4;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    private int[][] adjacencyMatrix;
    private int vertices;

    public GraphTraversal(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1;
        adjacencyMatrix[to][from] = 1; // Đối với đồ thị vô hướng
    }

    public void dfs(int startNode) {
        boolean[] visited = new boolean[vertices];
        dfsRecursive(startNode, visited);
    }

    private void dfsRecursive(int currentNode, boolean[] visited) {
        System.out.print(currentNode + " ");
        visited[currentNode] = true;

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[currentNode][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    public void bfs(int startNode) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        GraphTraversal graphAlgorithms = new GraphTraversal(vertices);

        // Add edges to the graph
        graphAlgorithms.addEdge(0, 1);
        graphAlgorithms.addEdge(0, 2);
        graphAlgorithms.addEdge(1, 3);
        graphAlgorithms.addEdge(1, 4);
        graphAlgorithms.addEdge(2, 5);

        // Perform DFS starting from node 0
        System.out.println("DFS Traversal:");
        graphAlgorithms.dfs(0);
        System.out.println();

        // Perform BFS starting from node 0
        System.out.println("BFS Traversal:");
        graphAlgorithms.bfs(0);
    }
}

