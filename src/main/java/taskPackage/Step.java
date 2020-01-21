package taskPackage;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;

@Getter
@Setter
public class Step {
    String stepName;

    Class actionTarget;

    Method actionMethod;

    boolean canRetry;

    boolean canRollback;

    boolean autoRollback;

    String rollbackStepName;

    Step rollbackStep;

    int order;

    Step(String stepName, Class actionTarget, Method actionMethon, boolean canRetry, boolean canRollback, int order) {
        this.stepName = stepName;
        this.actionMethod = actionMethon;
        this.actionTarget = actionTarget;
        this.canRetry = canRetry;
        this.canRollback = canRollback;
        this.order = order;
    }

    Step(String stepName, Class actionTarget, Method actionMethon, boolean canRetry, boolean canRollback, int order, String rollbackStepName) {
        this(stepName, actionTarget, actionMethon, canRetry, canRollback, order);
        this.rollbackStepName = rollbackStepName;
    }

    @Override
    public String toString(){
        return "{stepName: " + stepName + " ;actionTarget: " + actionTarget + "; actionMethod: "
                + actionMethod + "; canRetry: "+ canRetry + "; canRollback: " + canRollback +
                "; autoRollback: " + autoRollback + "; rollbackStep: " + rollbackStep + "}";
    }
}
