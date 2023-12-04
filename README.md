# Course Project - Distributed Algorithm (CSL7920)

## What Are We Doing
This repository contains implementations of two distributed algorithms for course project of CSL7920: Georouting and Node Coloring. Georouting involves routing messages based on geographical coordinates, while Node Coloring implements graph coloring algorithms for vertices in a network.

## Problem Description
Georouting: Georouting refers to routing messages to specific geographical coordinates within a network. The implemented algorithm follows a simple (greedy) protocol. 
Node Coloring: Node Coloring involves coloring vertices in a network based on certain rules and constraints. The implemented algorithms include both 3-coloring and 6-coloring.

## Code Overview/Working
### Georouting
**Simple (Greedy) Protocol**: At each node, the algorithm checks if the target coordinates match its own. If so, the routing is complete. Otherwise, it identifies the closest local neighbor in terms of Euclidean distance to the target and forwards the message to that neighbor.
Files for Georouting
- **Bundle.java**: Contains the data structure for bundling target coordinates and text messages.
- **GeoNode.java**: Defines the behavior of nodes in the georouting algorithm, handling message reception and routing.
- **MainGeorouting.java**: Sets up the topology, initializes nodes, and triggers the routing process upon node selection.
### Node Coloring
Node Coloring involves coloring vertices in a network based on certain rules and constraints. The implemented algorithms include both 3-coloring and 6-coloring.
Files for Node Coloring
- **MainColoring.java**: Sets up the network topology, initializes nodes, and triggers the chosen coloring algorithm (3-coloring or 6-coloring).
- **ColoringNode.java**: Defines the behavior of nodes in the coloring algorithms. For 6-coloring, it uses node IDs and message passing to assign colors while ensuring neighboring nodes have different colors.

## Getting Started

To run and test the code, follow these steps:

1\. Ensure you have the JBotSim library and dependencies set up in your development environment.
- Declaring your dependencies with Maven.
```
<dependency>
    <groupId>io.jbotsim</groupId>
    <artifactId>jbotsim-all</artifactId>
    <version>1.2.0</version>
</dependency>
```
2\. Clone this repository to your local machine:

```bash

git clone https://github.com/your-username/your-repo-name.git

```

3\. Compile and run the code using your preferred Java development environment or IDE.

## Usage
### Georouting
1. Run `MainGeorouting.java`.
2. Click on nodes in the displayed topology to select a source and target node.
3. The source node sends a message to the selected target node, demonstrating the georouting algorithm.

### Node Coloring
1. Choose the desired coloring algorithm (`3-coloring` or `6-coloring`) in `ColoringNode.java` by uncommenting the respective class.
2. Run `MainColoring.java`.
3. The network topology will be generated, and nodes will apply the chosen coloring algorithm.

## Additional Notes
- For georouting, the nodes are visualized in the JViewer with red indicating the source node and a flag icon marking the target node.
- Node coloring assigns colors (red, green, blue) based on the chosen algorithm and demonstrates the algorithm's execution in the generated topology.

## Acknowledgments
This project was developed as part of the Distributed Algorithm course (CSL7920) and is intended for educational purposes.

## Author
- [Gaurav Sangwan](https://github.com/gauravsangwan)
- [Saiyam Arora](https://github.com/SamArora18)

If you have any questions or need further assistance, feel free to reach out to me. Thank you for reviewing my project submission!
