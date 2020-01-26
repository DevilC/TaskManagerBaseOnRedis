package taskPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Task {
    /**
     * 任务名称，全局唯一标志
     */
    String taskName;

    /**
     * 业务类型
     */
    String businessType;

    /**
     * 是否任务互斥
     */
    boolean exclusive = false;

    /**
     * 互斥类型，当exclusive为true时生效
     */
    ExclusiveType exclusiveType;

    /**
     * 优先级，0为最高优先级
     */
    int level;

    /**
     * 执行过程是否可中断
     */
    boolean canInterrupt = false;

    /**
     * 初始化阶段Section列表
     */
    List<Section> initSection;

    /**
     * 执行阶段Section列表
     */
    List<Section> executeSection;

    /**
     * 结束阶段Section列表
     */
    List<Section> finallySection;

    /**
     * 超时时间，单位s
     */
    int timeout;

    @Override
    public boolean equals(Object item){
        if (!(item instanceof Task)) {
            return false;
        }
        Task taskItem = (Task) item;
        return this.taskName.equals(taskItem.getTaskName());
    }

    @Override
    public String toString(){
        return "TaskName: " + this.taskName + ";BusinessType: " + this.businessType + ";exclusive: " + exclusive + ";exclusiveType: " + this.exclusiveType + ";canInterrupt: " + this.canInterrupt
                + ";initSection: " + this.initSection
                + ";executeSection: " + this.executeSection
                + ";finallySection: " + this.finallySection
                + "timeout: " + timeout;
    }
}
