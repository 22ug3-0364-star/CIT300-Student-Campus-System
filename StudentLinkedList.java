public class StudentLinkedList {
    private Node head;

    // Add Student
    public void addStudent(Student student) {
        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists!");
            return;
        }
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Student added successfully!");
    }

    // Search Student by ID
    public Student searchStudent(String id) {
        Node current = head;
        while (current != null) {
            if (current.student.getStudentId().equals(id)) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    // Update Student
    public void updateStudent(String id, String name, String programme, double marks) {
        Student student = searchStudent(id);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        System.out.println("Student updated successfully!");
    }

    // Delete Student
    public boolean deleteStudent(String id) {
        if (head == null) return false;

        if (head.student.getStudentId().equals(id)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.student.getStudentId().equals(id)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display All Students
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node current = head;
        System.out.println("---- All Student Records ----");
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}