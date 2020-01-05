package resultPackage;

import java.util.List;

public interface ParentResult extends Result{
    /**
     * 获得所有子结果
     * @return List<Result>
     */
    List<ChildResult> getChildResults();

    /**
     * 子结果变化调用事件
     * @param result childResult
     */
    void childUpdateEvent(ChildResult result);
}
