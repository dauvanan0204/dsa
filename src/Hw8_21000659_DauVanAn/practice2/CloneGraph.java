package Hw8_21000659_DauVanAn.practice2;

import java.util.*;

public class CloneGraph {
    Node cloneGraph(Node node){
        return bfs(node);
    }
    public Node bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Integer, Node> valToNodeMap = new HashMap<>();
        Node clonedGraphStart = null;
        boolean isFirstNode = false;
        queue.add(node);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if(!visited.contains(currentNode)) {
                visited.add(currentNode);
                List<Node> neighbors = currentNode.neighbors;
                List<Node> newNeighbours = getNewNeighbours(neighbors, valToNodeMap);
                Node clonedNode = null;
                if(valToNodeMap.containsKey(currentNode.val)) {
                    clonedNode = valToNodeMap.get(currentNode.val);
                }
                else {
                    clonedNode = new Node(currentNode.val);
                    valToNodeMap.put(currentNode.val, clonedNode);
                }
                clonedNode.neighbors = new ArrayList<>(newNeighbours);
                if(!isFirstNode) {
                    isFirstNode = true;
                    clonedGraphStart = clonedNode;
                }
                for(int i=0; i<neighbors.size(); i++) {
                    queue.add(neighbors.get(i));
                }
            }
        }
        return clonedGraphStart;
    }

    public List<Node> getNewNeighbours(List<Node> neighbors, Map<Integer, Node> valToNodeMap) {
        List<Node> newNeighbors = new ArrayList<>();
        for(Node nieghbor: neighbors) {
            if(valToNodeMap.containsKey(nieghbor.val)) {
                newNeighbors.add(valToNodeMap.get(nieghbor.val));
            }
            else {
                Node newNode = new Node(nieghbor.val);
                newNeighbors.add(newNode);
                valToNodeMap.put(nieghbor.val, newNode);
            }
        }
        return newNeighbors;
    }
}
class Node{
    int val;
    ArrayList<Node> neighbors;
    public Node(){
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}