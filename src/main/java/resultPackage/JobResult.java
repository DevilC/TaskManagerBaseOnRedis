package resultPackage;

import taskPackage.Task;

import java.util.List;

public class JobResult extends ResultBase implements ParentResult {
    public List<ChildResult> getChildResults() {
        return null;
    }

    public void childUpdateEvent(ChildResult result) {
    }
}
