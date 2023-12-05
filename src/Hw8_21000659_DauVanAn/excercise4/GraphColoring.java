package Hw8_21000659_DauVanAn.excercise4;

import java.util.*;

public class GraphColoring {

    private int vertices;
    private List<List<Integer>> adjacencyList;

    public GraphColoring(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        this.adjacencyList.get(v).add(w);
        this.adjacencyList.get(w).add(v);
    }

    public void colorGraph() {
        int[] result = new int[vertices];
        Arrays.fill(result, -1);

        // Assign the first color to the first vertex
        result[0] = 0;

        // A temporary array to store the available colors.
        boolean[] available = new boolean[vertices];
        Arrays.fill(available, true);

        // Assign colors to remaining vertices
        for (int u = 1; u < vertices; u++) {
            // Process all adjacent vertices and flag their colors as unavailable
            for (int adjacent : adjacencyList.get(u)) {
                if (result[adjacent] != -1) {
                    available[result[adjacent]] = false;
                }
            }

            // Find the first available color
            int color;
            for (color = 0; color < vertices; color++) {
                if (available[color]) {
                    break;
                }
            }

            result[u] = color; // Assign the found color to the vertex

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }

        // Print the coloring result
        System.out.println("Vertex \t Color");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + result[i]);
        }

        // Find and print the chromatic number
        int chromaticNumber = Arrays.stream(result).max().getAsInt() + 1;
        System.out.println("Chromatic Number: " + chromaticNumber);
    }

    public static void main(String[] args) {
        GraphColoring graph = new GraphColoring(4);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        // Coloring the graph
        graph.colorGraph();
    }
}

