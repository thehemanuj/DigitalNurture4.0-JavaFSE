package TaskManagementSystem;

public class Task {

    int taskId;
    String taskName;
    String status;
    Task next=null;

    public Task(int taskId,String taskName,String status) {
        this.taskId=taskId;
        this.taskName=taskName;
        this.status=status;
    }    
}
