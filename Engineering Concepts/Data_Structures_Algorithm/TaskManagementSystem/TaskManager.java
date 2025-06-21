package TaskManagementSystem;

public class TaskManager {
    Task head;

    void addTask(int taskId,String taskName,String status){
        Task task=new Task(taskId, taskName, status);
        if(head==null){
            head=task;
            return;
        }
        Task temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=task;
    }

    Task search(int taskId,String taskName){
        Task temp=head;
        Task t=null;
        while(temp!=null){
            if(temp.taskId==taskId||temp.taskName.equalsIgnoreCase(taskName)){
                t=temp;
                break;
            }
            temp=temp.next;
        }
        if(t==null) System.out.println("Task Not Found");
        else{
            System.out.println("Task Found!");
        }
        return t;
    }

    void traverseTask(){
        if(head==null) {
            System.out.println("No Tasks!");
            return;
        }
        Task temp=head;
        while(temp!=null){
            System.out.println("\nId:"+temp.taskId);
            System.out.println("Name:"+temp.taskName);
            System.out.println("ststus:"+temp.status);
            temp=temp.next;
        }
    }

    void deleteTask(int taskId,String taskName){
        Task target=search(taskId,taskName);
        if(target==null){
            System.out.println("Task not found. Nothing to delete.");
            return;
        }
        if(head==target){
            head=head.next;
            System.out.println("Deleted task");
            return;
        }
        Task prev=head;
        while(prev!=null&&prev.next!=target){
            prev=prev.next;
        }
        if(prev!=null){
            prev.next=target.next;
            System.out.println("Deleted task");
        }
    }
}
