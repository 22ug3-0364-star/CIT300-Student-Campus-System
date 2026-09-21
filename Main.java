import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Graph graph = new Graph();

    int choice;

    do {
        System.out.println();
        System.out.println("===== Campus Route Management =====");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 10:
                System.out.print("Enter campus location: ");
                String location = scanner.nextLine();
                graph.addLocation(location);
                break;

            case 11:
                System.out.print("Enter location to remove: ");
                String removeLocation = scanner.nextLine();
                graph.removeLocation(removeLocation);
                break;

            case 12:
                System.out.print("Enter first location: ");
                String location1 = scanner.nextLine();

                System.out.print("Enter second location: ");
                String location2 = scanner.nextLine();

                graph.addConnection(location1, location2);
                break;

            case 13:
                System.out.print("Enter first location: ");
                String connection1 = scanner.nextLine();

                System.out.print("Enter second location: ");
                String connection2 = scanner.nextLine();

                graph.removeConnection(connection1, connection2);
                break;

            case 14:
                graph.displayConnections();
                break;

            case 15:
                System.out.print("Enter starting location for BFS: ");
                String startLocation = scanner.nextLine();

                graph.bfs(startLocation);
                break;

            case 0:
                System.out.println("Program terminated.");
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
        }

    } while (choice != 0);

    scanner.close();
}
}
