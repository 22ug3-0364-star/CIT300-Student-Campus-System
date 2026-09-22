public class Student {
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getProgramme() { return programme; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name +
               " | Programme: " + programme + " | Marks: " + marks;
    }
}