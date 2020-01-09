package taskLoadExceptionPackage;

public class TaskNotFoundException extends TaskDefineException{
    public TaskNotFoundException(String taskName){
        super("Task not found, taskName: " + taskName);
    }
}
