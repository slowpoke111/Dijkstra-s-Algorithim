/*
Stores a vertex that is being used in Dijkstra's algorithm.
The "label" is the name of vertex.
The "distance" tracks the shortest known distance from the source to the vertex.
The "previous" pointer keeps track of the previous vertex in the shortest path tree (SPT). Following the "previous" pointers will eventually lead to the source. In a connected graph, the source is the only vertex with a null "previous" pointer.
*/
public class Vertex<T> implements Comparable<Vertex<T>> {

    public T label;
    public int distance;
    public Vertex previous;

    public Vertex(T label) {
        this.label = label;
        this.distance = -1;
        this.previous = null;
    }

    public T getLabel() {
        return label;
    }

    public void setlabel(T label) {
        this.label = label;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public int compareTo(Vertex<T> other) {
        int result = distance - other.getDistance();
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String result = "Vertex: " + label +
                " Distance: " + distance +
                " Path: " + getShortestPath();
        return result;
    }

    public String getShortestPath() {
        if (previous == null) {
            return label.toString();
        }
        return label.toString() + ", " + previous.getShortestPath();
    }
}