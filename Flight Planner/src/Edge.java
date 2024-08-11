//Edge class contains Node destination and doubles cost and time, as well as required getters/setters
public class Edge {
    private Node destination; // Destination node of this edge
    private double cost; // Monetary cost of traveling this edge
    private double time; // Time to travel this edge

    // Constructor for the Edge class
    public Edge(Node destination, double cost, double time) {
        this.destination = destination;
        this.cost = cost;
        this.time = time;
    }

    // Getter for the destination node
    public Node getDestination() {
        return destination;
    }

    // Getter for the cost of the edge
    public double getCost() {
        return cost;
    }

    // Getter for the time of the edge
    public double getTime() {
        return time;
    }

    // Setter methods if you need to modify the edge's properties later
    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
