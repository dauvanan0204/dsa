package Hw8_21000659_DauVanAn.practice1;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ans.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            ans.get(edge[0]).add(edge[1]);
            ans.get(edge[1]).add(edge[0]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 5, E = 7;
        int[][] edges = {{0, 1}, {0, 4}, {4, 1}, {4, 3}, {1, 3}, {1, 2}, {3, 2}};
        System.out.println(new PrintAdjacencyList().printGraph(V, edges));
    }
}
