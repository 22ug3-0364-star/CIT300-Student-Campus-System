import java.util.HashMap;

public class StudentHashMap {
    private HashMap<String, Student> hashMap;

    public StudentHashMap() {
        hashMap = new HashMap<>();
    }

    // Add student to hash map
    public void addStudent(Student student) {
        if (hashMap.containsKey(student.getStudentId())) {
            System.out.println("Error: Student ID already exists in HashMap!");
            return;
        }
        hashMap.put(student.getStudentId(), student);
        System.out.println("Student added to HashMap successfully!");
    }

    // Fast search by Student ID
    public Student searchById(String id) {
        Student student = hashMap.get(id);
        if (student == null) {
            System.out.println("Student not found in HashMap!");
        }
        return student;
    }

    // Display all students in hashmap
    public void displayAll() {
        if (hashMap.isEmpty()) {
            System.out.println("No students in HashMap.");
            return;
        }
        System.out.println("---- Students in HashMap ----");
        for (Student s : hashMap.values()) {
            System.out.println(s);
        }
    }
}