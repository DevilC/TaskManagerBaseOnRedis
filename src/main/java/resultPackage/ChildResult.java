package resultPackage;

public interface ChildResult extends Result{
    /**
     * 获得parentResult
     * @return parentResult
     */
    ParentResult getParent();

    /**
     * 状态更新后通知Parent事件
     */
    void notifyParent();
}
