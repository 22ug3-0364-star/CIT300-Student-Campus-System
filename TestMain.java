public class TestMain {
    public static void main(String[] args) {
        // Test Stack (Recent Actions)
        ActionStack stack = new ActionStack();
        stack.pushAction("Added Student S001");
        stack.pushAction("Updated Student S001");
        stack.pushAction("Deleted Student S002");

        System.out.println("--- Recent Actions ---");
        stack.displayActions();

        System.out.println("\n--- Undo Last Action ---");
        String undone = stack.undoLastAction();
        System.out.println("Undone: " + undone);
        stack.displayActions();

        // Test Queue (Service Requests)
        ServiceQueue queue = new ServiceQueue();
        queue.addRequest(new ServiceRequest("S001", "Transcript Request"));
        queue.addRequest(new ServiceRequest("S002", "Fee Payment Query"));

        System.out.println("\n--- Pending Requests ---");
        queue.displayQueue();

        System.out.println("\n--- Processing Next Request ---");
        queue.processNextRequest();

        System.out.println("\n--- Remaining Requests ---");
        queue.displayQueue();
    }
}