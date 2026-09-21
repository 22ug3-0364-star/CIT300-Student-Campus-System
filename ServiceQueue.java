import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {
    private Queue<ServiceRequest> requestQueue;

    public ServiceQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add a service request to the queue
    public void addRequest(ServiceRequest request) {
        requestQueue.add(request);
        System.out.println("Service request added for Student ID: " + request.getStudentId());
    }

    // Process (remove) the next request in line
    public ServiceRequest processNextRequest() {
        if (requestQueue.isEmpty()) {
            System.out.println("No pending service requests!");
            return null;
        }
        ServiceRequest processed = requestQueue.poll();
        System.out.println("Processing: " + processed);
        return processed;
    }

    // Display all pending requests
    public void displayQueue() {
        if (requestQueue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("---- Pending Service Requests ----");
        for (ServiceRequest req : requestQueue) {
            System.out.println(req);
        }
    }
}
