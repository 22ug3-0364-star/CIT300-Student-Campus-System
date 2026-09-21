import java.util.*;

public class Graph {

private Map<String, List<String>> adjacencyList;

public Graph() {
    adjacencyList = new HashMap<>();
}

// 10. Add Campus Location
public void addLocation(String location) {

    if (location == null || location.trim().isEmpty()) {
        System.out.println("Location name cannot be empty!");
        return;
    }

    location = location.trim();

    if (adjacencyList.containsKey(location)) {
        System.out.println("Location already exists!");
        return;
    }

    adjacencyList.put(location, new ArrayList<>());

    System.out.println("Location added successfully!");
}

// 11. Remove Campus Location
public void removeLocation(String location) {

    if (location == null || location.trim().isEmpty()) {
        System.out.println("Location name cannot be empty!");
        return;
    }

    location = location.trim();

    if (!adjacencyList.containsKey(location)) {
        System.out.println("Location not found!");
        return;
    }

    adjacencyList.remove(location);

    for (List<String> neighbours : adjacencyList.values()) {
        neighbours.remove(location);
    }

    System.out.println("Location removed successfully!");
}

// 12. Add Campus Connection / Road
public void addConnection(String location1, String location2) {

    if (location1 == null || location2 == null
            || location1.trim().isEmpty()
            || location2.trim().isEmpty()) {

        System.out.println("Location names cannot be empty!");
        return;
    }

    location1 = location1.trim();
    location2 = location2.trim();

    if (!adjacencyList.containsKey(location1)
            || !adjacencyList.containsKey(location2)) {

        System.out.println("One or both locations do not exist!");
        return;
    }

    if (location1.equals(location2)) {
        System.out.println("A location cannot connect to itself!");
        return;
    }

    if (adjacencyList.get(location1).contains(location2)) {
        System.out.println("Connection already exists!");
        return;
    }

    adjacencyList.get(location1).add(location2);
    adjacencyList.get(location2).add(location1);

    System.out.println("Connection added successfully!");
}

// 13. Remove Campus Connection / Road
public void removeConnection(String location1, String location2) {

    if (location1 == null || location2 == null
            || location1.trim().isEmpty()
            || location2.trim().isEmpty()) {

        System.out.println("Location names cannot be empty!");
        return;
    }

    location1 = location1.trim();
    location2 = location2.trim();

    if (!adjacencyList.containsKey(location1)
            || !adjacencyList.containsKey(location2)) {

        System.out.println("One or both locations do not exist!");
        return;
    }

    if (!adjacencyList.get(location1).contains(location2)) {
        System.out.println("Connection does not exist!");
        return;
    }

    adjacencyList.get(location1).remove(location2);
    adjacencyList.get(location2).remove(location1);

    System.out.println("Connection removed successfully!");
}

// 14. Display Campus Connections
public void displayConnections() {

    if (adjacencyList.isEmpty()) {
        System.out.println("No campus locations available.");
        return;
    }

    System.out.println();
    System.out.println("----- Campus Network -----");

    for (String location : adjacencyList.keySet()) {

        System.out.print(location + " -> ");

        List<String> neighbours = adjacencyList.get(location);

        if (neighbours.isEmpty()) {
            System.out.println("No connections");
        } else {
            System.out.println(String.join(", ", neighbours));
        }
    }
}

// 15. BFS Traversal
public void bfs(String startLocation) {

    if (startLocation == null || startLocation.trim().isEmpty()) {
        System.out.println("Starting location cannot be empty!");
        return;
    }

    startLocation = startLocation.trim();

    if (!adjacencyList.containsKey(startLocation)) {
        System.out.println("Starting location not found!");
        return;
    }

    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();

    visited.add(startLocation);
    queue.add(startLocation);

    System.out.println();
    System.out.println("BFS Traversal:");

    boolean first = true;

    while (!queue.isEmpty()) {

        String current = queue.poll();

        if (!first) {
            System.out.print(" -> ");
        }

        System.out.print(current);

        first = false;

        for (String neighbour : adjacencyList.get(current)) {

            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                queue.add(neighbour);
            }
        }
    }

    System.out.println();
}
}
