import java.util.LinkedList;
import java.util.List;

//node class, used to represent each city airport, contains an integer index, a corresponding String name for the city
    //name, and a List of the outgoing edges in each city
public class Node {
    private int index; // Unique index for each node
    private String name; // Name of the city this node represents
    private List<Edge> edges; // List of edges from this node

    // Constructor to initialize the Node
    public Node(int index, String name) {
        this.index = index;
        this.name = name;
        this.edges = new LinkedList<>(); // Initialize the list of edges
    }

    // Method to add an edge, checks to see if there are duplicates,
        //NOT A DUPLICATE IF COST OR TIME IS DIFFERENT, EVEN IF START AND END NODE ARE THE SAME
    public void addEdge(Edge edge) {
        //Check if the edge already exists before adding
        for (Edge existingEdge : edges) {
            if (existingEdge.getDestination().equals(edge.getDestination())) {
                //if both edges have the same destination, check if they have the same cost and time,
                //  do not add edge if is duplicate, still add if diff cost or time
                if(existingEdge.getCost() == edge.getCost() && existingEdge.getTime() == edge.getTime()){
                    return;
                }
            }
        }
        // If the edge does not exist, add it to the list
        this.edges.add(edge);
    }

    // Getter for the node index
    public int getIndex() {
        return index;
    }

    // Setter for the node index
    public void setIndex(int index) {
        this.index = index;
    }

    // Getter for the city name
    public String getName() {
        return name;
    }

    // Setter for the city name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the edges list
    public List<Edge> getEdges() {
        return edges;
    }
}
