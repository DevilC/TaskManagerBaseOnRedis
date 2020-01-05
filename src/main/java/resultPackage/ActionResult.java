package resultPackage;

public class ActionResult extends ResultBase implements ChildResult {
    public ParentResult getParent() {
        return null;
    }

    public void notifyParent() {

    }
}
