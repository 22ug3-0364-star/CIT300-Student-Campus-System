public class ServiceRequest {
    private String studentId;
    private String requestDetails;

    public ServiceRequest(String studentId, String requestDetails) {
        this.studentId = studentId;
        this.requestDetails = requestDetails;
    }

    public String getStudentId() { return studentId; }
    public String getRequestDetails() { return requestDetails; }

    @Override
    public String toString() {
        return "Student ID: " + studentId + " | Request: " + requestDetails;
    }
}
