import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestPathTree {

    int[][] graph;
    ArrayList<Vertex<Integer>> vertices;
    PriorityQueue<Vertex<Integer>> unvisited;

    public void dijkstra(int[][] graph, int source) {

        vertices = new ArrayList<Vertex<Integer>>();
        unvisited = new PriorityQueue<Vertex<Integer>>();

        for (int i = 0; i < graph.length; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        for (Vertex<Integer> i : vertices) {
            i.distance = Integer.MAX_VALUE;
            if (source == i.label) {
                i.distance = 0;
            }
            unvisited.add(i);
        }

        while (!unvisited.isEmpty()) {
            Vertex<Integer> curr = unvisited.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[curr.label][i] != 0) {
                    Vertex<Integer> node = vertices.get(i);
                    if (node.distance > curr.distance + graph[curr.label][i]) {
                        unvisited.remove(node);
                        node.distance = curr.distance + graph[curr.label][i];
                        node.previous = curr;
                        unvisited.add(node);
                    }
                }
            }
        }
        for (Vertex<Integer> i : vertices) {
            System.out.println(i);
        }
    }
} 