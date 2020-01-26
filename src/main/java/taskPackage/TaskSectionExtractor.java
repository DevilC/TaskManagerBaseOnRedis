package taskPackage;

import java.util.List;

public class TaskSectionExtractor {
    Task task;
    List<Class> classList;

    public TaskSectionExtractor(Task task, List<Class> classList) {
        this.task = task;
        this.classList = classList;
    }

    public Task doExtractor(){
        return new Task();
    }
}
