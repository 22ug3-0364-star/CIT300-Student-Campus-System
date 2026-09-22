public class StudentBST {
    private BSTNode root;

    // Insert student into BST (based on Student ID)
    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private BSTNode insertRec(BSTNode node, Student student) {
        if (node == null) {
            return new BSTNode(student);
        }
        if (student.getStudentId().compareTo(node.student.getStudentId()) < 0) {
            node.left = insertRec(node.left, student);
        } else if (student.getStudentId().compareTo(node.student.getStudentId()) > 0) {
            node.right = insertRec(node.right, student);
        } else {
            System.out.println("Error: Student ID already exists in BST!");
        }
        return node;
    }

    // Search student by ID
    public Student search(String id) {
        return searchRec(root, id);
    }

    private Student searchRec(BSTNode node, String id) {
        if (node == null) return null;
        if (id.equals(node.student.getStudentId())) return node.student;
        if (id.compareTo(node.student.getStudentId()) < 0) {
            return searchRec(node.left, id);
        } else {
            return searchRec(node.right, id);
        }
    }

    // In-order traversal - displays students sorted by ID
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No students in the tree.");
            return;
        }
        System.out.println("---- Students (Sorted by ID - BST In-Order) ----");
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.student);
            inOrderRec(node.right);
        }
    }
}