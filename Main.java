import java.util.Scanner;

public class Main {
    static StudentLinkedList linkedList = new StudentLinkedList();
    static ActionStack actionStack = new ActionStack();
    static ServiceQueue serviceQueue = new ServiceQueue();
    static StudentBST bst = new StudentBST();
    static StudentHashMap hashMap = new StudentHashMap();
    static Graph graph = new Graph();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: linkedList.displayAll(); break;
                case 5: addServiceRequest(); break;
                case 6: serviceQueue.processNextRequest(); break;
                case 7: actionStack.displayActions(); break;
                case 8: bst.displayInOrder(); break;
                case 9: searchByHashing(); break;
                case 10: addLocation(); break;
                case 11: removeLocation(); break;
                case 12: addConnection(); break;
                case 13: removeConnection(); break;
                case 14: graph.displayConnections(); break;
                case 15: traverseGraph(); break;
                case 16: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 16);

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n===== University Student Record & Campus Route Management System =====");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST/AVL");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS/DFS");
        System.out.println("16. Exit");
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Programme: ");
        String prog = sc.nextLine();
        double marks = getDoubleInput("Enter Marks (0-100): ");

        if (marks < 0 || marks > 100) {
            System.out.println("Error: Invalid marks! Must be between 0-100.");
            return;
        }

        Student student = new Student(id, name, prog, marks);
        linkedList.addStudent(student);
        bst.insert(student);
        hashMap.addStudent(student);
        actionStack.pushAction("Added Student " + id);
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Programme: ");
        String prog = sc.nextLine();
        double marks = getDoubleInput("Enter new Marks: ");

        linkedList.updateStudent(id, name, prog, marks);
        actionStack.pushAction("Updated Student " + id);
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        if (linkedList.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
            actionStack.pushAction("Deleted Student " + id);
        } else {
            System.out.println("Error: Student not found!");
        }
    }

    static void searchByHashing() {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine();
        Student result = hashMap.searchById(id);
        if (result != null) {
            System.out.println("Found: " + result);
        }
    }

    static void addServiceRequest() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Request Details: ");
        String details = sc.nextLine();
        serviceQueue.addRequest(new ServiceRequest(id, details));
    }

    static void addLocation() {
        System.out.print("Enter campus location name: ");
        String loc = sc.nextLine();
        graph.addLocation(loc);
    }

    static void removeLocation() {
        System.out.print("Enter location to remove: ");
        String loc = sc.nextLine();
        graph.removeLocation(loc);
    }

    static void addConnection() {
        System.out.print("Enter first location: ");
        String loc1 = sc.nextLine();
        System.out.print("Enter second location: ");
        String loc2 = sc.nextLine();
        graph.addConnection(loc1, loc2);
    }

    static void removeConnection() {
        System.out.print("Enter first location: ");
        String loc1 = sc.nextLine();
        System.out.print("Enter second location: ");
        String loc2 = sc.nextLine();
        graph.removeConnection(loc1, loc2);
    }

        static void traverseGraph() {
        System.out.print("Enter starting location: ");
        String start = sc.nextLine();
        graph.bfs(start);
    }

    static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }
}