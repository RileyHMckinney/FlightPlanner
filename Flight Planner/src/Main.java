/*CS3345.501 - Semester Project - Flight Planner - Riley Mckinney

*******************READ ME*********************
The lines setting the paths to each input file need to be adjusted based on the path to the file in your personal
system. Copy the path\\to\\sampleFlightData.txt to where EDGE_DATA_FILE_PATH is defined, and do the same for
requestedFlightPlans

The code is output into the file output.txt and the standard out. Check all files in the directory of the rest of the
classes to find where the output.txt is located.

*/
import java.util.*;

public class Main {
    // Paths to the data files
    private static final String EDGE_DATA_FILE_PATH = "C:\\Users\\TTG\\Desktop\\Flight Planner\\src\\sampleFlightData.txt";
    private static final String REQUEST_FILE_PATH = "C:\\Users\\TTG\\Desktop\\Flight Planner\\src\\requestedFlightPlans.txt";

    //main function
    public static void main(String[] args) {
        // Create and populate the graph
        Graph graph = new Graph();
        GraphLoader.loadEdgesFromFile(graph, EDGE_DATA_FILE_PATH);  // Populate the graph with flight data

        // Initialize PathFinder with the populated graph
        PathFinder pathFinder = new PathFinder(graph);

        // Load requests from REQUEST_FILE_PATH into a linked list of flight requests
        List<RequestLoader.FlightRequest> requests = RequestLoader.loadRequests(REQUEST_FILE_PATH);
        int flightNo = 1;

        //iterate through the requests and print the resultant three shortest paths
        for (RequestLoader.FlightRequest request : requests) {
            pathFinder.computeAllRoutes(request.getStartCity(), request.getEndCity(), request.getPreference(), flightNo);
            flightNo++;
        }
    }
}
