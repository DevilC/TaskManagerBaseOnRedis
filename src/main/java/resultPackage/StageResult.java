package resultPackage;

import java.util.List;

public class StageResult extends ResultBase implements ParentResult {
    public List<ChildResult> getChildResults() {
        return null;
    }

    public void childUpdateEvent(ChildResult result) {

    }
}
