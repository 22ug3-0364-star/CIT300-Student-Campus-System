public class TestMain {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        
        list.addStudent(new Student("S001", "Dilini", "CIT", 85.5));
        list.addStudent(new Student("S002", "Buddini", "CIT", 78.0));
        
        System.out.println("\n--- After Adding ---");
        list.displayAll();
        
        list.updateStudent("S001", "Dilini K", "CIT", 90.0);
        System.out.println("\n--- After Updating S001 ---");
        list.displayAll();
        
        list.deleteStudent("S002");
        System.out.println("\n--- After Deleting S002 ---");
        list.displayAll();
    }
}