
# Optimal Airplane Route Finder

## Project Overview

This project is designed to find the optimal routes between two cities based on user-defined criteria such as minimum cost or minimum travel time. The application uses a graph data structure to represent cities as nodes and direct connections between them as edges, with each edge having an associated cost and travel time.

## Features

- **Graph Representation:** Cities are represented as nodes, and direct flight paths between them are represented as edges.
- **Optimal Route Calculation:** Users can find the best routes between cities based on either minimum cost or minimum travel time.
- **Depth-First Search (DFS):** The project utilizes a DFS algorithm to explore all possible paths between two cities, sorting them by the specified criteria.
- **Custom Data Input:** Flight data and route requests are loaded from external files, making the application flexible and easy to adapt to different datasets.

## Project Structure

- **`Edge.java`:** Defines the `Edge` class, representing a connection between two cities, including the cost and travel time.
- **`Node.java`:** Defines the `Node` class, representing a city in the graph.
- **`Graph.java`:** Manages the graph structure, handling the addition of nodes and edges and supporting pathfinding operations.
- **`GraphLoader.java`:** Handles loading the graph data from the `sampleFlightData.txt` file.
- **`RequestLoader.java`:** Loads flight plan requests from the `requestedFlightPlans.txt` file.
- **`PathFinder.java`:** Contains the logic for finding the optimal path between cities based on the user's criteria (cost or time).
- **`Main.java`:** The main entry point for the application, orchestrating the loading of data, processing of requests, and output of results.

## How to Run

1. **Compile the Java Files:**
   ```
   javac *.java
   ```

2. **Run the Application:**
   ```
   java Main
   ```

3. **Input Files:**
   - **`sampleFlightData.txt`:** Contains the flight data, listing direct connections between cities with their respective costs and travel times.
   - **`requestedFlightPlans.txt`:** Contains the flight plans that specify the origin, destination, and whether the user is optimizing for cost (C) or time (T).

4. **Output:** The application will process the flight plans and output the optimal routes based on the given criteria.

## Example Data

### `sampleFlightData.txt`:
```
Dallas|Austin|98|47
Austin|Houston|95|39
Dallas|Houston|101|51
Chicago|New York|200|210
Los Angeles|San Francisco|150|90
... (more entries)
```

### `requestedFlightPlans.txt`:
```
Dallas|Houston|T
Chicago|Dallas|C
Los Angeles|New York|T
Boston|Miami|C
... (more entries)
```

## License

This project is licensed under the MIT License. You are free to use, modify, and distribute this software, provided that the original copyright notice and permission notice are included in all copies or substantial portions of the Software.

```
MIT License

Copyright (c) 2024 Riley Mckinney

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Contact

For any questions or feedback, please feel free to reach out:

- Email: mckinneyriley13@gmail.com
- LinkedIn: [riley-mckinney](https://www.linkedin.com/in/riley-mckinney/)
- GitHub: [RileyHMckinney](https://github.com/RileyHMckinney)
