import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

//RequestLoader class used to read from the requestedFlightPlans.txt file and parse the request,
    //each FlightRequest object contains three components, the start city string, the end city string, and the pref of
    //cost or time
public class RequestLoader {

    //scans through the desired file based on pipe delim, returns a List of FlightRequest objects populated by the flight requests
    public static List<FlightRequest> loadRequests(String filePath) {
        List<FlightRequest> requests = new ArrayList<>();

        //read the file, add each new request to the FlightRequest List
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int numberOfRequests = Integer.parseInt(reader.readLine().trim());  // Read the number of requests
            for (int i = 0; i < numberOfRequests; i++) {
                String line = reader.readLine();
                if (line != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        String startCity = parts[0].trim();
                        String endCity = parts[1].trim();
                        char preference = parts[2].trim().charAt(0);  // 'T' for time, 'C' for cost
                        requests.add(new FlightRequest(startCity, endCity, preference));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {   //error checking
            System.out.println("Error processing the file: " + e.getMessage());
        }

        //at end of file, return populated FlightRequest object list
        return requests;
    }

    //Flight Request object: contains start city string, end city string, and preference character, along with required
        //getters and setters to modify above param
    public static class FlightRequest {
        private String startCity;
        private String endCity;
        private char preference;  // 'T' for time, 'C' for cost

        public FlightRequest(String startCity, String endCity, char preference) {
            this.startCity = startCity;
            this.endCity = endCity;
            this.preference = preference;
        }

        public String getStartCity() {
            return startCity;
        }

        public String getEndCity() {
            return endCity;
        }

        public char getPreference() {
            return preference;
        }
    }
}
