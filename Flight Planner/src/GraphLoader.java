import java.io.*;

//GraphLoader class is used to build a graph based on sampleFlightData.txt file

public class GraphLoader {
    //loadEdgesFromFile(): checks to see if the startCity and endCity already exist in the graph, if they do not, create them
        //adds the edge using the param startCity and endCity, parsed from each line of the input file
    public static void loadEdgesFromFile(Graph graph, String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //the first line of the file is expected to be the number of edges to be added
            String firstLine = reader.readLine(); // Read the first line to get the number of edges
            if (firstLine != null) {
                int numberOfEdges = Integer.parseInt(firstLine.trim()); // Parse the number of edges
                for (int i = 0; i < numberOfEdges; i++) {
                    String line = reader.readLine();
                    if (line != null) {
                        String[] parts = line.split("\\|"); // Split line on pipe character
                        if (parts.length == 4) {
                            String startCity = parts[0].trim();
                            String endCity = parts[1].trim();
                            double cost = Double.parseDouble(parts[2].trim());
                            double time = Double.parseDouble(parts[3].trim());

                            //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                            //addNode() and addEdge() check for existing nodes/edges with same properties to avoid dupes
                            //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

                            graph.addNode(startCity, graph.getAllNodes().size()); // Adds node if not already added
                            graph.addNode(endCity, graph.getAllNodes().size()); // Adds node if not already added
                            //adds edge from startCity to endCity
                            graph.addEdge(startCity, endCity, cost, time);
                            //adds edge from endCity to startCity
                            graph.addEdge(endCity, startCity, cost, time);
                        }
                    } else {
                        throw new IOException("Unexpected end of file after " + i + " edges.");
                    }
                }
            }
            //error checking for file read failures
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numerical values: " + e.getMessage());
        }
    }
}
