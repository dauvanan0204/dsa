package Hw8_21000659_DauVanAn.excercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    private final int vertices;
    private final List<Edge> edges;

    public Graph(int vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Edge> findMinimumSpanningTree() {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;
        int index = 0;

        while (edgeCount < vertices - 1) {
            Edge nextEdge = edges.get(index++);
            int sourceParent = find(parent, nextEdge.source);
            int destinationParent = find(parent, nextEdge.destination);

            if (sourceParent != destinationParent) {
                result.add(nextEdge);
                union(parent, sourceParent, destinationParent);
                edgeCount++;
            }
        }

        return result;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        parent[xParent] = yParent;
    }
}

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int vertices = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Graph graph = new Graph(vertices, edges);
        List<Edge> minimumSpanningTree = graph.findMinimumSpanningTree();

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }
}

