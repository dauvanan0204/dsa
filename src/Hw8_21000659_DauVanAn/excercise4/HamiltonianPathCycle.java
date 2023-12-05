package Hw8_21000659_DauVanAn.excercise4;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianPathCycle {

    private static int[][] graph;

    public static void main(String[] args) {
        int vertices = 5;

        // Khởi tạo ma trận đồ thị vô hướng
        graph = new int[vertices][vertices];

        // Thêm các cạnh
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(3, 4);

        System.out.println("Hamiltonian Path:");
        findHamiltonianPath(0);

        System.out.println("\nHamiltonian Cycle:");
        findHamiltonianCycle();
    }

    private static void addEdge(int source, int destination) {
        graph[source][destination] = 1;
        graph[destination][source] = 1;
    }

    private static void findHamiltonianPath(int startVertex) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        path.add(startVertex);
        visited[startVertex] = true;

        if (hamiltonianPathUtil(startVertex, visited, path)) {
            for (Integer vertex : path) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No Hamiltonian Path exists.");
        }
    }

    private static boolean hamiltonianPathUtil(int currentVertex, boolean[] visited, List<Integer> path) {
        if (path.size() == graph.length) {
            return true;
        }

        for (int vertex = 0; vertex < graph.length; vertex++) {
            if (graph[currentVertex][vertex] == 1 && !visited[vertex]) {
                path.add(vertex);
                visited[vertex] = true;

                if (hamiltonianPathUtil(vertex, visited, path)) {
                    return true;
                }

                path.remove(path.size() - 1);
                visited[vertex] = false;
            }
        }

        return false;
    }

    private static void findHamiltonianCycle() {
        List<Integer> cycle = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        cycle.add(0);
        visited[0] = true;

        if (hamiltonianCycleUtil(0, visited, cycle, 1)) {
            for (Integer vertex : cycle) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No Hamiltonian Cycle exists.");
        }
    }

    private static boolean hamiltonianCycleUtil(int currentVertex, boolean[] visited, List<Integer> cycle, int pos) {
        if (pos == graph.length) {
            if (graph[currentVertex][cycle.get(0)] == 1) {
                return true;
            } else {
                return false;
            }
        }

        for (int vertex = 0; vertex < graph.length; vertex++) {
            if (graph[currentVertex][vertex] == 1 && !visited[vertex]) {
                cycle.add(vertex);
                visited[vertex] = true;

                if (hamiltonianCycleUtil(vertex, visited, cycle, pos + 1)) {
                    return true;
                }

                cycle.remove(cycle.size() - 1);
                visited[vertex] = false;
            }
        }

        return false;
    }
}

