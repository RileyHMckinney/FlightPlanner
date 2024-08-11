import java.util.LinkedList;
import java.util.List;

//Graph class: a linked list of contained Nodes, each with their own linked lists of edges, creating an ADJACENCY LIST
public class Graph {
    private List<Node> nodes; // Using LinkedList to store nodes

    //constructor
    public Graph() {
        this.nodes = new LinkedList<>();
    }

    // Method to add a node to the graph
    public void addNode(String cityName, int index) {
        // Check if node already exists before adding
        if (getNode(cityName) == null) {
            nodes.add(new Node(index, cityName));
        }
    }

    // Method to add an edge to the graph
    public void addEdge(String startCity, String endCity, double cost, double time) {
        Node startNode = getNode(startCity); // Find start city
        Node endNode = getNode(endCity); // Find end city

        if (startNode == null || endNode == null) {
            System.out.println("Start or end city not found");
            return;
        }

        // Create new edge and place it in the respective start node
        Edge newEdge = new Edge(endNode, cost, time);

        //add the newEdge to the start node, pointing to the endNode
        startNode.addEdge(newEdge);
    }

    // Getter for a node by city name, searching linearly
    public Node getNode(String cityName) {
        for (Node node : nodes) {
            if (node.getName().equals(cityName)) {
                return node;
            }
        }
        return null;
    }

    // Method to get all nodes in the graph
    public List<Node> getAllNodes() {
        return new LinkedList<>(nodes);
    }

    // Method to print the entire graph (Used in Debugging, not used in final impl)
    public void printGraph() {
        System.out.println("Graph representation:");
        for (Node node : nodes) {
            System.out.print(node.getName() + " -> ");
            List<Edge> edges = node.getEdges();
            if (edges.isEmpty()) {
                System.out.println("No outgoing edges.");
            } else {
                for (Edge edge : edges) {
                    System.out.print("[To: " + edge.getDestination().getName() + ", Cost: " + edge.getCost() + ", Time: " + edge.getTime() + "] ");
                }
                System.out.println(); // Move to the next line after listing all edges for a node
            }
        }
    }
}
