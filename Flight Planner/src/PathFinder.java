import java.util.*;
//below are the required imports to write to output.txt
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

//PathFinder class: used to compute all paths in the graph from origin, record all the paths from origin to destination
    //in a list of paths, and then sort and print the shortest three path
public class PathFinder {
    private final Graph travelGraph;

    //constructor
    public PathFinder(Graph graph) {
        this.travelGraph = graph;
    }

    //computeAllRoutes(): impl of the DFS algorithm, that records each successful path found from origin to destination
        //in discoveredPaths List
    public void computeAllRoutes(String origin, String destination, char mode, int routeNumber) {
        //get the origin and destination, check for valid param
        Node originNode = travelGraph.getNode(origin);
        Node destinationNode = travelGraph.getNode(destination);
        if (originNode == null || destinationNode == null) {
            logResult("One or both specified nodes not found.", routeNumber);
            return;
        }

        //initialize a stack of Paths
        Stack<Path> pathStack = new Stack<>();
        //initialize an initialRoute Path object
        Path initialRoute = new Path();

        //add the originNode to the initial route Path and push the route to the stack
        initialRoute.addNode(originNode);
        pathStack.push(initialRoute);

        //create a list of discovered paths from origin to destination
        List<Path> discoveredPaths = new LinkedList<>();

        //while there are still paths that need to be explored
        while (!pathStack.isEmpty()) {
            //backtracks and loads last node
            Path activePath = pathStack.pop();
            Node currentTerminal = activePath.getLastNode();

            //checks for basecase
            if (currentTerminal.equals(destinationNode)) {
                discoveredPaths.add(new Path(activePath));
            } else {
                //extend the current path and add the node, totalCost and totalTime to the path
                for (Edge edge : currentTerminal.getEdges()) {
                    if (!activePath.containsNode(edge.getDestination())) {
                        Path extendedPath = new Path(activePath);
                        extendedPath.extendPath(edge.getDestination(), edge.getCost(), edge.getTime());
                        pathStack.push(extendedPath);
                    }
                }
            }
        }

        //sort the paths in the discoveredPaths list
        manuallySortPaths(discoveredPaths, mode);

        //use StringBuilder objects to create an output to print
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("\nFlight ").append(routeNumber).append(": ")
                .append(origin).append(", ").append(destination).append(" (")
                .append(mode == 'C' ? "Cost" : "Time").append(")\n");

        //if there are no routes from origin to destination
        if (discoveredPaths.isEmpty()) {
            resultBuilder.append("No routes available.\n");
        } else { //if there are routes from origin to destination, print the top three
            for (int i = 0; i < Math.min(3, discoveredPaths.size()); i++) {
                Path path = discoveredPaths.get(i);
                resultBuilder.append("Route ").append(i + 1).append(": ")
                        .append(path).append(", Time: ").append(path.getTime())
                        .append(", Cost: ").append(path.getCost()).append("\n");
            }
        }

        //prints the result to file "output.txt"
        logResult(resultBuilder.toString(), routeNumber);
    }

    //manuallySortPaths: blob sort impl, sorts paths in path List from smallest to largest, based on totalCost or totalTime
    private void manuallySortPaths(List<Path> paths, char preference) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < paths.size() - 1; i++) {
                Path current = paths.get(i);
                Path next = paths.get(i + 1);
                if ((preference == 'C' && current.getCost() > next.getCost()) ||
                        (preference == 'T' && current.getTime() > next.getTime())) {
                    paths.set(i, next);
                    paths.set(i + 1, current);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    //logResults(): write the output stdout to output.txt
    private void logResult(String output, int routeNumber) {
        //print to standard out
        System.out.println(output);

        //write to output.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt", true))) {
            writer.print(output);
        } catch (IOException e) {
            System.err.println("Failed to write to output.txt for flight " + routeNumber + ": " + e.getMessage());
        }

    }

    //Path object: keeps track of nodes visited in LinkedList of nodes, as well as to totalCost and totalTime
        //also contains relevant getters/setters
    static class Path {
        private LinkedList<Node> routeNodes = new LinkedList<>();
        private double totalCost = 0;
        private double totalTime = 0;

        public Path() {}

        public Path(Path other) {
            this.routeNodes = new LinkedList<>(other.routeNodes);
            this.totalCost = other.totalCost;
            this.totalTime = other.totalTime;
        }

        public void addNode(Node node) {
            routeNodes.addLast(node);
        }

        public void extendPath(Node node, double cost, double time) {
            addNode(node);
            addCost(cost);
            addTime(time);
        }

        public Node getLastNode() {
            return routeNodes.getLast();
        }

        public boolean containsNode(Node node) {
            return routeNodes.contains(node);
        }

        public void addCost(double cost) {
            this.totalCost += cost;
        }

        public void addTime(double time) {
            this.totalTime += time;
        }

        public double getCost() {
            return totalCost;
        }

        public double getTime() {
            return totalTime;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Node node : routeNodes) {
                if (builder.length() > 0) builder.append(" -> ");
                builder.append(node.getName());
            }
            return builder.toString();
        }
    }
}
