package taskLoadExceptionPackage;

public class TaskDefineTagWrongException extends TaskDefineException {
    public TaskDefineTagWrongException(String tagName) {
        super("Task define tag is wrong or necessary, tag: " + tagName);
    }
}
