package taskPackage;

public abstract class TaskExtractor {
    Class targetClass;

    public TaskExtractor(Class targetClass){
        this.targetClass = targetClass;
    }

    abstract Task doExtractor();




}
