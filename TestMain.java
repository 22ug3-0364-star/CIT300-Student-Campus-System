public class TestMain {
    public static void main(String[] args) {
        // Test BST
        StudentBST bst = new StudentBST();
        bst.insert(new Student("S003", "Pethumi", "CIT", 88.0));
        bst.insert(new Student("S001", "Dilini", "CIT", 85.5));
        bst.insert(new Student("S004", "Wanninayaka", "CIT", 92.0));

        System.out.println("--- BST In-Order Display ---");
        bst.displayInOrder();

        System.out.println("\n--- BST Search S001 ---");
        Student found = bst.search("S001");
        System.out.println(found != null ? found : "Not found");

        // Test HashMap
        StudentHashMap map = new StudentHashMap();
        map.addStudent(new Student("S003", "Pethumi", "CIT", 88.0));
        map.addStudent(new Student("S001", "Dilini", "CIT", 85.5));

        System.out.println("\n--- HashMap Display ---");
        map.displayAll();

        System.out.println("\n--- HashMap Search S003 ---");
        Student result = map.searchById("S003");
        System.out.println(result != null ? result : "Not found");
    }
}