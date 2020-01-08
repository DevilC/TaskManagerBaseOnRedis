package taskPackage;

public class TaskFactory {
    private static TaskFactory instance = new TaskFactory();



    public TaskFactory getInstance(){
        return instance;
    }
}
